import React, { useContext } from 'react';
import { View, Text } from 'react-native';
import { UsernameContext } from '../Context/Context';

export default function HomeScreen() {
  const [username] = useContext(UsernameContext);

  return (
    <View style={{ padding: 20 }}>
      <Text>Welcome!</Text>
      {username && <Text>You are logged in as {username}</Text>}
    </View>
  );
}