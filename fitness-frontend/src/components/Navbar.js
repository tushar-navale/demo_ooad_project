import { Link } from 'react-router-dom';
import { AppBar, Toolbar, Button, Typography } from '@mui/material';

export default function Navbar({ userId }) {
    return (
        <AppBar position="static">
            <Toolbar>
                <Typography variant="h6" component="div" sx={{ flexGrow: 1 }}>
                    Fitness Tracker
                </Typography>
                <Button color="inherit" component={Link} to="/">Home</Button>
                {userId ? (
                    <>
                        <Button color="inherit" component={Link} to={`/profile/${userId}`}>Profile</Button>
                        <Button color="inherit" component={Link} to="/blogs">Blogs</Button>
                        <Button color="inherit" component={Link} to="/new-blog">New Blog</Button>
                    </>
                ) : (
                    <Button color="inherit" component={Link} to="/login">Login</Button>
                )}
            </Toolbar>
        </AppBar>
    );
}