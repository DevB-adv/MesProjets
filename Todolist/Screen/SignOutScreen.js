import React from 'react';
import { View, Text, Button } from 'react-native';
import { TokenContext, UsernameContext } from '../Context/Context';


export default function SignOutScreen({ navigation }) {
    return (
      <TokenContext.Consumer>
        {([token, setToken]) => (
          <UsernameContext.Consumer>
            {([username, setUsername]) => (
              <View style={{ padding: 20 }}>
                <Text>Sign Out</Text>
                <Button
                  title="Sign Out"
                  onPress={() => {
                    setToken(null);
                    setUsername(null);
                    navigation.navigate('SIGNIN');
                  }}
                />
                {token && (
                  <Text style={{ marginTop: 20 }}>
                  </Text>
                )}
              </View>
            )}
          </UsernameContext.Consumer>
        )}
      </TokenContext.Consumer>
    );
}