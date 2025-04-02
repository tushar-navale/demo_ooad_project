import { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import { Container, Typography, Box, Card, CardContent, Button, TextField } from '@mui/material';
import axios from 'axios';

export default function Blog({ user }) {
    const [blogs, setBlogs] = useState([]);
    const [comments, setComments] = useState({});
    const [newComment, setNewComment] = useState('');

    useEffect(() => {
        const fetchBlogs = async () => {
            const { data } = await axios.get('/api/blogs');
            setBlogs(data);
        };
        fetchBlogs();
    }, []);

    const handleLike = async (blogId) => {
        await axios.post(`/api/blogs/${blogId}/like`);
        setBlogs(blogs.map(blog => 
            blog.id === blogId ? {...blog, likes: blog.likes + 1} : blog
        ));
    };

    const handleComment = async (blogId) => {
        if (!newComment.trim()) return;
        const { data } = await axios.post(
            `/api/blogs/${blogId}/comment/${user.id}`,
            { content: newComment }
        );
        setComments({...comments, [blogId]: [...(comments[blogId] || []), data]});
        setNewComment('');
    };

    return (
        <Container maxWidth="md">
            <Typography variant="h4" sx={{ my: 4 }}>Community Blogs</Typography>
            {blogs.map(blog => (
                <Card key={blog.id} sx={{ mb: 3 }}>
                    <CardContent>
                        <Typography variant="h5">{blog.title}</Typography>
                        <Typography color="text.secondary">By {blog.user.name}</Typography>
                        <Typography sx={{ mt: 2 }}>{blog.content}</Typography>
                        <Box sx={{ display: 'flex', alignItems: 'center', mt: 2 }}>
                            <Button onClick={() => handleLike(blog.id)}>Like ({blog.likes})</Button>
                        </Box>
                        <Box sx={{ mt: 2 }}>
                            <Typography variant="h6">Comments</Typography>
                            {(comments[blog.id] || []).map(comment => (
                                <Box key={comment.id} sx={{ p: 2, border: '1px solid #eee', my: 1 }}>
                                    <Typography>{comment.user.name}: {comment.content}</Typography>
                                </Box>
                            ))}
                            {user && (
                                <Box sx={{ mt: 2 }}>
                                    <TextField
                                        label="Add a comment"
                                        fullWidth
                                        value={newComment}
                                        onChange={(e) => setNewComment(e.target.value)}
                                    />
                                    <Button onClick={() => handleComment(blog.id)}>Post</Button>
                                </Box>
                            )}
                        </Box>
                    </CardContent>
                </Card>
            ))}
        </Container>
    );
}