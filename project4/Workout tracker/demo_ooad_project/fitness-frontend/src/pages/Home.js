import { Link } from 'react-router-dom';
import { Button, Container, Typography, Box } from '@mui/material';

export default function Home({ user }) {
  return (
    <Container maxWidth="md">
      <Box sx={{ mt: 4, textAlign: 'center' }}>
        <Typography variant="h3" gutterBottom>
          Welcome to Fitness Tracker
        </Typography>
        
        {user ? (
          <>
            <Typography variant="h5" sx={{ mb: 3 }}>
              Hello, {user.name}!
            </Typography>
            <Button 
              component={Link} 
              to={`/profile/${user.id}`}
              variant="contained"
              sx={{ mr: 2 }}
            >
              View Profile
            </Button>
          </>
        ) : (
          <Button 
            component={Link} 
            to="/login"
            variant="contained"
            size="large"
          >
            Get Started
          </Button>
        )}
      </Box>
    </Container>
  );
}