import { useState, useEffect } from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import { TextField, Button, Container, Typography, Box } from '@mui/material';
import axios from 'axios';

export default function Profile({ user }) {
    const { id } = useParams();
    const [profile, setProfile] = useState(null);
    const [editMode, setEditMode] = useState(false);
    const [formData, setFormData] = useState({});
    const navigate = useNavigate();

    useEffect(() => {
        const fetchProfile = async () => {
            try {
                const { data } = await axios.get(`http://localhost:8080/api/users/${id}`);
                setProfile(data);
                setFormData(data);
            } catch (error) {
                console.error('Profile fetch error:', error);
                //setError('Failed to load profile');
            }
        };
        fetchProfile();
    }, [id]);

    const handleUpdate = async () => {
        const { data } = await axios.put(`/api/users/${id}`, formData);
        setProfile(data);
        setEditMode(false);
    };

    if (!profile) return <div>Loading...</div>;

    return (
        <Container maxWidth="md">
            <Box sx={{ mt: 4 }}>
                {editMode ? (
                    <Box component="form">
                        <TextField
                            label="Name"
                            value={formData.name || ''}
                            onChange={(e) => setFormData({...formData, name: e.target.value})}
                            fullWidth
                            margin="normal"
                        />
                        {/* Add other fields similarly */}
                        <Button onClick={handleUpdate} variant="contained">Save</Button>
                        <Button onClick={() => setEditMode(false)}>Cancel</Button>
                    </Box>
                ) : (
                    <>
                        <Typography variant="h4">{profile.name}</Typography>
                        <Typography>Age: {profile.age}</Typography>
                        <Typography>Gender: {profile.gender}</Typography>
                        <Typography>Weight: {profile.weight}</Typography>
                        <Typography>Height: {profile.height}</Typography>
                        <Typography>Fitness Level: {profile.fitnessLevel}</Typography>
                        {user?.id === profile.id && (
                            <Button onClick={() => setEditMode(true)}>Edit Profile</Button>
                        )}
                    </>
                )}
            </Box>
        </Container>
    );
}