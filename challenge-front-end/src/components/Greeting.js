import {useState} from 'react';


function Greeting({name,message}) {
    const [messageState, setMessage] = useState(message); 
    const changeMessage = () => {
        setMessage("Have a great day!");
    } 
    return (
    <div>  
    <h2>Hello, {name}!</h2>
    <p>{messageState}</p>
    <button onClick={changeMessage}>Change Message</button>
    </div>
    ); 
}

export default Greeting;