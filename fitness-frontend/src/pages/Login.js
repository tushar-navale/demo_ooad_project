import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { TextField, Button, Container, Typography, Box } from '@mui/material';
import axios from 'axios';

export default function Login({ setUser }) {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [isRegister, setIsRegister] = useState(false);
    const navigate = useNavigate();

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const url = isRegister ? '/api/auth/register' : '/api/auth/login';
            // const { data } = await axios.post(url, { email, password });
            // setUser(data);
            // navigate(`/profile/${data.id}`);
            const { data } = await axios.post(url, { email, password });
            setUser(data);
            navigate(`/profile/${data.id}`);
        } catch (error) {
            console.error(error);
        }
    };

    return (
        <Container maxWidth="sm">
            <Box sx={{ mt: 8, display: 'flex', flexDirection: 'column', alignItems: 'center' }}>
                <Typography variant="h5">{isRegister ? 'Register' : 'Login'}</Typography>
                <Box component="form" onSubmit={handleSubmit} sx={{ mt: 1 }}>
                    <TextField
                        margin="normal"
                        fullWidth
                        label="Email"
                        value={email}
                        onChange={(e) => setEmail(e.target.value)}
                    />
                    <TextField
                        margin="normal"
                        fullWidth
                        label="Password"
                        type="password"
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                    />
                    <Button
                        type="submit"
                        fullWidth
                        variant="contained"
                        sx={{ mt: 3, mb: 2 }}
                    >
                        {isRegister ? 'Register' : 'Login'}
                    </Button>
                    <Button onClick={() => setIsRegister(!isRegister)}>
                        {isRegister ? 'Already have an account? Login' : 'Need an account? Register'}
                    </Button>
                </Box>
            </Box>
        </Container>
    );
}