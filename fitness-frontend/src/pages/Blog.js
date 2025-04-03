import { useState, useEffect } from 'react';
import { TextField, Button, Typography, Box, Container, Avatar } from '@mui/material';
import axios from 'axios';

export default function Blog({ user }) {
    const [blogs, setBlogs] = useState([]);
    const [comments, setComments] = useState({});
    const [newComment, setNewComment] = useState('');
    const [error, setError] = useState(null);

    useEffect(() => {
        const fetchBlogs = async () => {
            try {
                const { data } = await axios.get('http://localhost:8080/api/blogs');
                setBlogs(data);
                // Initialize comments for each blog
                const commentsObj = {};
                data.forEach(blog => {
                    commentsObj[blog.id] = [];
                });
                setComments(commentsObj);
            } catch (error) {
                console.error('Error fetching blogs:', error);
                setError('Failed to load blogs');
            }
        };
        fetchBlogs();
    }, []);

    const handleCommentSubmit = async (blogId) => {
        if (!newComment.trim()) return;
        
        try {
            const response = await axios.post(`http://localhost:8080/api/blogs/${blogId}/comments`, {
                content: newComment,
                user: { id: user.id }
            });
            
            setComments({
                ...comments,
                [blogId]: [...comments[blogId], response.data]
            });
            setNewComment('');
        } catch (error) {
            console.error('Error posting comment:', error);
            setError('Failed to post comment');
        }
    };

    return (
        <Container maxWidth="md">
            {error && <Typography color="error">{error}</Typography>}
            {blogs.map(blog => (
                <Box key={blog.id} sx={{ mt: 4, mb: 4, p: 2, border: '1px solid #e0e0e0', borderRadius: 1 }}>
                    <Box sx={{ display: 'flex', alignItems: 'center', mb: 2 }}>
                        <Avatar sx={{ mr: 2 }}>{blog.user?.name?.[0] || '?'}</Avatar>
                        <Box>
                            <Typography variant="h5">{blog.title}</Typography>
                            <Typography variant="subtitle2" color="text.secondary">
                                Posted by {blog.user?.name || 'Anonymous'}
                            </Typography>
                        </Box>
                    </Box>
                    <Typography sx={{ mb: 2 }}>{blog.content}</Typography>
                    <Box sx={{ mt: 2 }}>
                        {comments[blog.id]?.map(comment => (
                            <Box key={comment.id} sx={{ mt: 1, display: 'flex', alignItems: 'center' }}>
                                <Avatar sx={{ width: 24, height: 24, mr: 1, fontSize: '0.875rem' }}>
                                    {comment.user?.name?.[0] || '?'}
                                </Avatar>
                                <Box>
                                    <Typography variant="caption" color="text.secondary">
                                        {comment.user?.name || 'Anonymous'}
                                    </Typography>
                                    <Typography variant="body2">{comment.content}</Typography>
                                </Box>
                            </Box>
                        ))}
                        {user && (
                            <Box sx={{ mt: 2 }}>
                                <TextField
                                    size="small"
                                    value={newComment}
                                    onChange={(e) => setNewComment(e.target.value)}
                                    placeholder="Add a comment..."
                                />
                                <Button 
                                    onClick={() => handleCommentSubmit(blog.id)}
                                    variant="contained" 
                                    size="small" 
                                    sx={{ ml: 1 }}
                                >
                                    Comment
                                </Button>
                            </Box>
                        )}
                    </Box>
                </Box>
            ))}
        </Container>
    );
}