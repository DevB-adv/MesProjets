import React, { useState,useContext } from 'react';
import { View, Text, TextInput, Button } from 'react-native';
import { TokenContext, UsernameContext } from '../Context/Context';

import {signIn} from '../components/sign';



export default function SignInScreen({ navigation }) {
  const [inputUsername, setInputUsername] = useState('');
  const [inputPassword, setInputPassword] = useState('');
  const [errorMessage, setErrorMessage] = useState('');

  const [username,setUsername] = useContext(UsernameContext);
  const [token,setToken] = useContext(TokenContext);


  const  login = async ()=>{
    setErrorMessage('');
    if(inputPassword!="" && inputUsername!=""){
      await signIn(inputUsername,inputPassword).then(token=>{
        setToken(token)
        setUsername(inputUsername)
        navigation.navigate('Home');
      }).catch(err=>{
        console.log(err)
        setErrorMessage("Invalid username or password. Please try again."); 
      });
  } else {
    setErrorMessage("Both fields are required."); 
  }
};


  return (
   
            <View style={{ padding: 20 }}>
              <Text>Sign In</Text>
              
              <TextInput
                placeholder="Username"
                value={inputUsername}
                onChangeText={setInputUsername}
              
                style={{ borderWidth: 1, marginBottom: 10, padding: 8 }}
              />

              <TextInput
                placeholder="Password"
                value={inputPassword}
                onChangeText={setInputPassword}
                style={{ borderWidth: 1, marginBottom: 10, padding: 8 }}
                secureTextEntry
              />

              <Button
                title="Sign In"
                onPress={login}
              />
              {errorMessage !== '' && (
        <Text style={{ color: 'red', marginTop: 10 }}>{errorMessage}</Text>
        )}
              
              {token && (
                <Text style={{ marginTop: 20 }}>
                  Vous êtes connecté en tant que {username}
                </Text>
              )}
            </View>
          )}
      