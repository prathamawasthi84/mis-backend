import axios from "axios";
import { useState } from "react";
function Login() {
  const[email, setEmail] = useState('');
  const[password ,setPassword] = useState('');

  const handleLogin = async() =>{
   try{
    const response = await axios.post('http://localhost:8080/user/login',{
      email: email,
      password: password
    });
    console.log(response.data);
    localStorage.setItem('token',response.data);
  }catch(error){
    console.error('Login failed',error);
  }
}

  return (
    <div className="container mt-5">
     <div className="row justify-content-center">
      <div className="col-md-4">
        <div className="card">
          <div className="card-body">
            <h1 className="text-center">Login</h1>
            <div className="mb-3">
              <label>Email</label>
              <input type="email" 
              className="form-control" 
              placeholder="Enter email"
              value={email}
              onChange={(e)=>setEmail(e.target.value)}/>
              </div>
              <div>
              <label>Password</label>
              <input type="password" 
              className="form-control" 
              placeholder="Enter password"
              value={password}
              onChange={(e)=>setPassword(e.target.value)}/>
              </div>
              <div className="mt-3">
              <button className="btn btn-primary w-100" onClick={handleLogin}>Login</button>
            </div>
          </div>
        </div>
      </div>
     </div>
     </div>
  )
}

export default Login;