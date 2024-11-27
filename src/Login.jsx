import React, { useState } from 'react';
import { useNavigate, Link } from 'react-router-dom';
import { loginUser } from './api';
import './Login.css'; 

const Login = ({ onLogin }) => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const navigate = useNavigate();

    const handleLogin = async () => {
        try {
            await loginUser(username, password);
            onLogin();
            navigate('/home');
        } catch (error) {
            console.error('There was an error logging in!', error);
        }
    };

    return (
        <div className="login-container">
            <h2>Login</h2>
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
            <button onClick={handleLogin} className="login-button">Login</button>
            <div className="register-link">
                <span>Don't have an account?</span>
                <Link to="/register" className="register-button-link">Register</Link>
            </div>
        </div>
    );
};

export default Login;
