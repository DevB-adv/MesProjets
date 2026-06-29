import React , {useState, useEffect} from "react";
import { View, Switch , Text , StyleSheet , Image ,TouchableOpacity } from 'react-native';


    
  

export default function TodoItem(props){
    const [done, setIsEnabled] = useState(props.item.done);




    useEffect(() => {
        setIsEnabled(props.item.done)
     }, [props.item.done])


    const toggleSwitch = () => {
        setIsEnabled(!done); 
        props.funcSwitch(props.item.id);
        
    }
    return (
        <View style={styles.container}>
            <Switch
            trackColor={{false: 'grey', true: 'teal'}}
            thumbColor={done ? '#f5dd4b' : '#f4f3f4'}
            ios_backgroundColor="#3e3e3e"
            onValueChange={toggleSwitch}
            value={done}
           
            />

    

            <Text style={[styles.text_item,{textDecorationLine : done ? 'line-through' : 'none'},
            {marginLeft:20 } , ]}>{props.item.content}</Text>  
            <TouchableOpacity  
             onPress={() => props.deleteTodo(props.item.id)}
            >
            <Image source={require('../assets/trash.png')} 
            style={{height:20, width:20 ,marginLeft:10 }}/>
            </TouchableOpacity>
        </View>
    )
}

const styles = StyleSheet.create({
    container: {
      flex: 1,
      backgroundColor: 'white',
      alignItems: 'center',
      justifyContent: 'center',
      flexDirection: 'row',
      
    },
  });