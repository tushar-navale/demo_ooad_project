import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { TextField, Button, Container, Typography, Box, Alert } from '@mui/material';
import axios from 'axios';

export default function NewBlog({ user }) {
    const [title, setTitle] = useState('');
    const [content, setContent] = useState('');
    const [error, setError] = useState('');
    const navigate = useNavigate();

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const response = await axios.post('http://localhost:8080/api/blogs', {
                title,
                content,
                user: { id: user.id }
            });
            
            if (response.status === 200) {
                navigate('/blogs');
            }
        } catch (error) {
            console.error('Error creating blog:', error);
            setError('Failed to create blog post');
        }
    };

    return (
        <Container maxWidth="md">
            <Box sx={{ mt: 4 }}>
                <Typography variant="h4">Create New Blog Post</Typography>
                {error && <Alert severity="error" sx={{ mt: 2 }}>{error}</Alert>}
                <Box component="form" onSubmit={handleSubmit} sx={{ mt: 2 }}>
                    <TextField
                        label="Title"
                        fullWidth
                        value={title}
                        onChange={(e) => setTitle(e.target.value)}
                        margin="normal"
                        required
                    />
                    <TextField
                        label="Content"
                        fullWidth
                        multiline
                        rows={4}
                        value={content}
                        onChange={(e) => setContent(e.target.value)}
                        margin="normal"
                        required
                    />
                    <Button 
                        type="submit" 
                        variant="contained" 
                        sx={{ mt: 2 }}
                    >
                        Post
                    </Button>
                </Box>
            </Box>
        </Container>
    );
}