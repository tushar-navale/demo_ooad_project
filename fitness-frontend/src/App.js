import { useState } from 'react';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Navbar from './components/Navbar';
import Home from './pages/Home';
import Login from './pages/Login';
import Profile from './pages/Profile';
import Blog from './pages/Blog';
import NewBlog from './pages/NewBlog';

function App() {
    const [user, setUser] = useState(null);

    return (
        <BrowserRouter>
            <Navbar userId={user?.id} />
            <Routes>
                <Route path="/" element={<Home user={user} />} />
                <Route path="/login" element={<Login setUser={setUser} />} />
                <Route path="/profile/:id" element={<Profile user={user} />} />
                <Route path="/blogs" element={<Blog user={user} />} />
                <Route path="/new-blog" element={<NewBlog user={user} />} />
            </Routes>
        </BrowserRouter>
    );
}

export default App;