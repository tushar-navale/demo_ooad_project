import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { TextField, Button, Container, Typography, Box, Alert, CircularProgress } from '@mui/material';
import axios from 'axios';

export default function Login({ setUser }) {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [isRegister, setIsRegister] = useState(false);
    const [error, setError] = useState('');
    const [loading, setLoading] = useState(false);
    const navigate = useNavigate();

    const validateInputs = () => {
        if (!email || !password) {
            setError('Please fill in all fields');
            return false;
        }
        if (!email.includes('@')) {
            setError('Please enter a valid email');
            return false;
        }
        if (password.length < 2) {
            setError('Password must be at least 6 characters');
            return false;
        }
        return true;
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        setError('');
        
        if (!validateInputs()) {
            return;
        }
    
        setLoading(true);
        try {
            // Remove withCredentials and simplify the request
            const response = await axios.post(
                'http://localhost:8080/api/auth/login',
                { email, password }
            );
            
            const { data } = response;
            console.log('Login response:', data); // Add logging
            
            if (data && data.id) {
                setUser(data);
                navigate(`/profile/${data.id}`);
            } else {
                setError('Invalid response from server');
            }
        } catch (error) {
            console.error('Login error details:', error.response || error);
            setError('Login failed. Please try again.');
        } finally {
            setLoading(false);
        }
    };

    return (
        <Container maxWidth="sm">
            <Box sx={{ mt: 8, display: 'flex', flexDirection: 'column', alignItems: 'center' }}>
                <Typography variant="h5" sx={{ mb: 3 }}>
                    {isRegister ? 'Register' : 'Login'}
                </Typography>
                
                {error && (
                    <Alert severity="error" sx={{ width: '100%', mb: 2 }}>
                        {error}
                    </Alert>
                )}

                <Box component="form" onSubmit={handleSubmit} sx={{ mt: 1, width: '100%' }}>
                    <TextField
                        margin="normal"
                        required
                        fullWidth
                        label="Email"
                        type="email"
                        value={email}
                        onChange={(e) => setEmail(e.target.value)}
                        disabled={loading}
                        error={!!error && error.includes('email')}
                    />
                    <TextField
                        margin="normal"
                        required
                        fullWidth
                        label="Password"
                        type="password"
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                        disabled={loading}
                        error={!!error && error.includes('password')}
                    />
                    <Button
                        type="submit"
                        fullWidth
                        variant="contained"
                        sx={{ mt: 3, mb: 2 }}
                        disabled={loading}
                    >
                        {loading ? (
                            <CircularProgress size={24} color="inherit" />
                        ) : (
                            isRegister ? 'Register' : 'Login'
                        )}
                    </Button>
                    <Button 
                        onClick={() => {
                            setIsRegister(!isRegister);
                            setError('');
                        }}
                        fullWidth
                        variant="text"
                    >
                        {isRegister ? 'Already have an account? Login' : 'Need an account? Register'}
                    </Button>
                </Box>
            </Box>
        </Container>
    );
}