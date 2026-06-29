import React from 'react';
import { createNativeStackNavigator } from '@react-navigation/native-stack';
import TodoListsScreen from '../Screen/TodoListsScreen';
import TodoList from '../components/TodoList';

const Stack = createNativeStackNavigator();

export default function NavigationTodo() {
  return (
    <Stack.Navigator 
      initialRouteName="TodoLists"
      screenOptions={{
        headerStyle: {
          backgroundColor: '#2196f3',
        },
        headerTintColor: '#fff',
        headerTitleStyle: {
          fontWeight: 'bold',
        },
      }}
    >
      <Stack.Screen 
        name="TodoLists" 
        component={TodoListsScreen}
        options={{
          title: 'My Todo Lists'
        }}
      />
      <Stack.Screen 
        name="Details" 
        component={TodoList}
        options={({ route }) => ({ 
          title: route.params?.title || 'Todo List',
          headerBackTitle: 'Back'
        })}
      />
    </Stack.Navigator>
  );
}

