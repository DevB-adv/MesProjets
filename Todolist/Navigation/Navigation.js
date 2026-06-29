import React, { useContext } from 'react';
import { NavigationContainer } from '@react-navigation/native';
import { createBottomTabNavigator } from '@react-navigation/bottom-tabs';

import NavigationTodo from './NavigationTodo';
import HomeScreen from '../Screen/HomeScreen';
import SignOutScreen from '../Screen/SignOutScreen';
import SignInScreen from '../Screen/SignInScreen';
import SignUpScreen from '../Screen/SignUpScreen';
import { TokenContext } from '../Context/Context';

const Tab = createBottomTabNavigator();

export default function Navigation() {
  const [token] = useContext(TokenContext);

  return (
    <NavigationContainer>
      {token == null ? (
        <Tab.Navigator>
          <Tab.Screen 
            name="SIGNIN" 
            component={SignInScreen}
            options={{
              title: 'Sign In'
            }}
          />
          <Tab.Screen 
            name="SIGNUP" 
            component={SignUpScreen}
            options={{
              title: 'Sign Up'
            }}
          />
        </Tab.Navigator>
      ) : (
        <Tab.Navigator>
          <Tab.Screen 
            name="Home" 
            component={HomeScreen}
            options={{
              title: 'Home'
            }}
          />
          <Tab.Screen 
            name="TodoLists" 
            component={NavigationTodo}
            options={{
              headerShown: false,
              title: 'Todo Lists'
            }}
          />
          <Tab.Screen 
            name="SignOut" 
            component={SignOutScreen}
            options={{
              title: 'Sign Out'
            }}
          />
        </Tab.Navigator>
      )}
    </NavigationContainer>
  );
}
