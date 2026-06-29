import React, { useState,useContext } from 'react';
import { View, Text, TextInput, Button } from 'react-native';
import { TokenContext, UsernameContext } from '../Context/Context';

import {signUp} from '../components/sign';



export default function SignUpScreen({ navigation }) {
  const [inputUsername, setInputUsername] = useState('');
  const [inputPassword, setInputPassword] = useState('');
  

  const [username,setUsername] = useContext(UsernameContext);
  const [token,setToken] = useContext(TokenContext);


  const  subscribe = ()=>{
    if(inputPassword!="" && inputUsername!=""){
       signUp(inputUsername,inputPassword).then(token=>{
        setToken(token)
        setUsername(inputUsername)
        navigation.navigate('Home');
      }).catch(err=>{
        console.log(err)
      })
    }
  
  }


  return (
   
            <View style={{ padding: 20 }}>
              <Text>Sign Up</Text>
              
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
                title="Sign Up"
                onPress={subscribe}
              />
              
              {token && (
                <Text style={{ marginTop: 20 }}>
                  Vous êtes connecté en tant que {username}
                </Text>
              )}
            </View>
          )}