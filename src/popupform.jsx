import React, { useState } from 'react';
import './popup.css';

function PopupForm1() {
  const [showForm, setShowForm] = useState(false);

  const handleButtonClick = () => {
    setShowForm(!showForm);
  };

  return (
    <div className="App1">
      <button onClick={handleButtonClick}>
        {showForm ? 'Hide Form' : 'Show Form'}
      </button>
      {showForm && <MyForm />}
    </div>
  );
}

function MyForm() {
  return (
    <form>
      <div>
        <label>Name:</label>
        <input type="text" name="name" />
      </div>
      <div>
        <label>Email:</label>
        <input type="email" name="email" />
      </div>
      <button type="submit">Submit</button>
    </form>
  );
}

export default PopupForm1;
