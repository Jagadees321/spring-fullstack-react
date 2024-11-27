import React, { useState } from 'react';
import axios from 'axios';
import './Home.css'; 

const Home = () => {
    const [email, setEmail] = useState('');
    const [subject, setSubject] = useState('');
    const [message, setMessage] = useState('');
    const [status, setStatus] = useState('');

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const response = await axios.post('/call/send-mail', {
                email,
                subject,
                message,
            });
            setStatus(response.data);
        } catch (error) {
            console.error('Error sending email', error);
            setStatus('Failed to send email.');
        }
    };

    return (
        <div className="home-container">
            <h2>Send Email</h2>
            <form onSubmit={handleSubmit} className="email-form">
                <div className="form-group">
                    <label htmlFor="email">Email:</label>
                    <input
                        type="email"
                        id="email"
                        value={email}
                        onChange={(e) => setEmail(e.target.value)}
                        required
                    />
                </div>
                <div className="form-group">
                    <label htmlFor="subject">Subject:</label>
                    <input
                        type="text"
                        id="subject"
                        value={subject}
                        onChange={(e) => setSubject(e.target.value)}
                        required
                    />
                </div>
                <div className="form-group">
                    <label htmlFor="message">Message:</label>
                    <textarea
                        id="message"
                        value={message}
                        onChange={(e) => setMessage(e.target.value)}
                        required
                    />
                </div>
                <button type="submit" className="send-button">Send Email</button>
            </form>
            {status && <p className="status-message">{status}</p>}
        </div>
    );
};

export default Home;
