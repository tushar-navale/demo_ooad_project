// import { useState, useEffect } from 'react';
// import { useParams, useNavigate } from 'react-router-dom';
// import { TextField, Button, Container, Typography, Box } from '@mui/material';
// import axios from 'axios';

// export default function Profile({ user }) {
//     const { id } = useParams();
//     const [profile, setProfile] = useState(null);
//     const [editMode, setEditMode] = useState(false);
//     const [formData, setFormData] = useState({});
//     const [error, setError] = useState(null);
//     const navigate = useNavigate();

//     useEffect(() => {
//         const fetchProfile = async () => {
//             try {
//                 const { data } = await axios.get(`http://localhost:8080/api/users/${id}`);
//                 setProfile(data);
//                 setFormData(data);
//             } catch (error) {
//                 console.error('Profile fetch error:', error);
//                 setError('Failed to load profile');
//                 navigate('/login');
//             }
//         };
//         fetchProfile();
//     }, [id,navigate]);

//     // const handleUpdate = async () => {
//     //     try {
//     //         const { data } = await axios.put(`http://localhost:8080/api/users/${id}`, formData);
//     //         setProfile(data);
//     //         setEditMode(false);
//     //     } catch (error) {
//     //         console.error('Update error:', error);
//     //         setError('Failed to update profile');
            
//     //     }
//     // };
//     const handleUpdate = async () => {
//         try {
//             const { data } = await axios.put(
//                 `http://localhost:8080/api/users/${id}`, 
//                 formData,
//                 {
//                     headers: {
//                         'Content-Type': 'application/json'
//                     }
//                 }
//             );
//             setProfile(data);
//             setEditMode(false);
//         } catch (error) {
//             console.error('Update error:', error);
//             setError('Failed to update profile');
//         }
//     };

    

//     //if (!profile) return <div>Loading...</div>;
//     if (!profile) return <div>{error || 'Loading...'}</div>;  // Update this line to show errors

//     return (
//         <Container maxWidth="md">
//             <Box sx={{ mt: 4 }}>
//                 {editMode ? (
//                     <Box component="form">
//                         <TextField
//                             label="Name"
//                             value={formData.name || ''}
//                             onChange={(e) => setFormData({...formData, name: e.target.value})}
//                             fullWidth
//                             margin="normal"
//                         />
//                         {/* Add other fields similarly */}
//                         <Button onClick={handleUpdate} variant="contained">Save</Button>
//                         <Button onClick={() => setEditMode(false)}>Cancel</Button>
//                     </Box>
//                 ) : (
//                     <>
//                         <Typography variant="h4">{profile.name}</Typography>
//                         <Typography>Age: {profile.age}</Typography>
//                         <Typography>Gender: {profile.gender}</Typography>
//                         <Typography>Weight: {profile.weight}</Typography>
//                         <Typography>Height: {profile.height}</Typography>
//                         <Typography>Fitness Level: {profile.fitnessLevel}</Typography>
//                         {user?.id === profile.id && (
//                             <Button onClick={() => setEditMode(true)}>Edit Profile</Button>
//                         )}
//                     </>
//                 )}
//             </Box>
//         </Container>
//     );
// }

import { useState, useEffect } from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import { TextField, Button, Container, Typography, Box } from '@mui/material';
import axios from 'axios';

export default function Profile({ user }) {
    const { id } = useParams();
    const [profile, setProfile] = useState(null);
    const [editMode, setEditMode] = useState(false);
    const [formData, setFormData] = useState({});
    const [error, setError] = useState(null);
    const navigate = useNavigate();

    useEffect(() => {
        const fetchProfile = async () => {
            try {
                const { data } = await axios.get(`http://localhost:8080/api/users/${id}`);
                setProfile(data);
                // Exclude name from formData if you don't want it to be editable
                const { name, ...editableFields } = data;
                setFormData(editableFields);
            } catch (error) {
                console.error('Profile fetch error:', error);
                setError('Failed to load profile');
                navigate('/login');
            }
        };
        fetchProfile();
    }, [id, navigate]);

    const handleUpdate = async () => {
        try {
            // Combine the original name with the updated fields
            const updateData = {
                ...formData,
                name: profile.name // Keep the original name
            };
            
            const { data } = await axios.put(
                `http://localhost:8080/api/users/${id}`, 
                updateData,
                {
                    headers: {
                        'Content-Type': 'application/json'
                    }
                }
            );
            setProfile(data);
            setEditMode(false);
        } catch (error) {
            console.error('Update error:', error);
            setError('Failed to update profile');
        }
    };

    if (!profile) return <div>{error || 'Loading...'}</div>;

    return (
        <Container maxWidth="md">
            <Box sx={{ mt: 4 }}>
                {editMode ? (
                    <Box component="form">
                        <Typography variant="h6" sx={{ mb: 2 }}>Name: {profile.name}</Typography>
                        <TextField
                            label="Age"
                            value={formData.age || ''}
                            onChange={(e) => setFormData({...formData, age: e.target.value})}
                            fullWidth
                            margin="normal"
                            type="number"
                        />
                        <TextField
                            label="Gender"
                            value={formData.gender || ''}
                            onChange={(e) => setFormData({...formData, gender: e.target.value})}
                            fullWidth
                            margin="normal"
                        />
                        <TextField
                            label="Weight"
                            value={formData.weight || ''}
                            onChange={(e) => setFormData({...formData, weight: e.target.value})}
                            fullWidth
                            margin="normal"
                            type="number"
                        />
                        <TextField
                            label="Height"
                            value={formData.height || ''}
                            onChange={(e) => setFormData({...formData, height: e.target.value})}
                            fullWidth
                            margin="normal"
                            type="number"
                        />
                        <TextField
                            label="Fitness Level"
                            value={formData.fitnessLevel || ''}
                            onChange={(e) => setFormData({...formData, fitnessLevel: e.target.value})}
                            fullWidth
                            margin="normal"
                        />
                        <Button onClick={handleUpdate} variant="contained" sx={{ mt: 2 }}>Save</Button>
                        <Button onClick={() => setEditMode(false)} sx={{ mt: 2, ml: 2 }}>Cancel</Button>
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
                            <Button onClick={() => setEditMode(true)} variant="contained" sx={{ mt: 2 }}>
                                Edit Profile
                            </Button>
                        )}
                    </>
                )}
            </Box>
        </Container>
    );
}