import React, { useState } from 'react';
import { useNavigate , Link} from 'react-router-dom';
import { registerUser } from './api';
import './Register.css'; 

const Register = () => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const navigate = useNavigate();

    const handleRegister = async () => {
        try {
            await registerUser(username, password);
            navigate('/login');
        } catch (error) {
            console.error('There was an error registering!', error);
        }
    };

    return (
        <div className="register-container">
            <h2>Register</h2>
            <input
                type="text"
                placeholder="Username"
                value={username}
                onChange={(e) => setUsername(e.target.value)}
            />
            <input
                type="password"
                placeholder="Password"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
            />
            <button onClick={handleRegister} className="register-button">Register</button>
            <div className="register-link">
                <span>Do have an account?</span>
                <Link to="/login" className="register-button-link">Login</Link>
            </div>
        </div>
    );
};

export default Register;
