import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './CustomerSearch.css'; 

const CustomerSearch = () => {
    const [searchTerm, setSearchTerm] = useState('');
    const [customers, setCustomers] = useState([]);

    useEffect(() => {
        axios.get('https://jsonplaceholder.typicode.com/posts')
            .then((response) => {
                const customerData = response.data.map(user => ({
                    id: user.id,
                    title: user.title,
                    body: user.body
                }));
                setCustomers(customerData);
            })
            .catch(error => console.error('Error fetching data:', error));
    }, []);

    const handleChange = (event) => {
        setSearchTerm(event.target.value);
    };

    const filteredCustomers = customers.filter(customer =>
        customer.title.toLowerCase().includes(searchTerm.toLowerCase())
    );

    return (
        <div className="customer-search">
            <input 
                type="text" 
                placeholder="Search customers..." 
                value={searchTerm} 
                onChange={handleChange} 
                className="search-bar"
            />
            <ul className="customer-list">
                {filteredCustomers.map((customer) => (
                    <li key={customer.id} className="customer-item">
                        <h3>{customer.title}</h3>
                        <p>{customer.body}</p>
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default CustomerSearch;
