import React, { useState, useContext, useEffect } from 'react';
import { View, Text, TextInput, Button, StyleSheet, FlatList, TouchableOpacity } from 'react-native';
import { TokenContext, UsernameContext } from '../Context/Context';
import { createTodoList, getTodoLists, deleteTodoList } from '../components/todoList2';

export default function TodoListsScreen({ navigation }) {
  const [username] = useContext(UsernameContext);
  const [token] = useContext(TokenContext);
  const [todoLists, setTodoLists] = useState([]);
  const [newListTitle, setNewListTitle] = useState('');

  useEffect(() => {
    if (username && token) {
      fetchTodoLists();
    }

    
    const unsubscribe = navigation.addListener('focus', () => {
      if (username && token) {
        fetchTodoLists();
      }
    });

    return unsubscribe;
  }, [username, token, navigation]);

  const fetchTodoLists = async () => {
    try {
      const lists = await getTodoLists(username, token);
      setTodoLists(lists);
    } catch (error) {
      console.error('Failed to fetch todo lists:', error);
    }
  };

  const handleCreateList = async () => {
    if (newListTitle.trim()) {
      try {
        const newList = await createTodoList(username, newListTitle, token);
        setNewListTitle('');
        fetchTodoLists();
        
        navigation.navigate('Details', { 
          todoListId: newList.id,
          title: newList.title 
        });
      } catch (error) {
        console.error('Failed to create todo list:', error);
      }
    }
  };

  const handleDeleteList = async (id) => {
    try {
      await deleteTodoList(id, token);
      fetchTodoLists();
    } catch (error) {
      console.error('Failed to delete todo list:', error);
    }
  };

  const navigateToList = (list) => {
    navigation.navigate('Details', { 
      todoListId: list.id,
      title: list.title 
    });
  };

  return (
    <View style={styles.container}>
      <Text style={styles.welcome}>Welcome {username}!</Text>
      
      <View style={styles.inputContainer}>
        <TextInput
          style={styles.input}
          value={newListTitle}
          onChangeText={setNewListTitle}
          placeholder="Enter new a todolist"
          onSubmitEditing={handleCreateList}
        />
        <TouchableOpacity 
          style={styles.createButton}
          onPress={handleCreateList}
        >
          <Text style={styles.createButtonText}>Create List</Text>
        </TouchableOpacity>
      </View>

      <FlatList
        data={todoLists}
        keyExtractor={(item) => item.id}
        renderItem={({ item }) => (
          <View style={styles.listItem}>
            <TouchableOpacity 
              style={styles.listTouchable}
              onPress={() => navigateToList(item)}
            >
              <View style={styles.listContent}>
                <Text style={styles.listTitle}>{item.title}</Text>
                <TouchableOpacity 
                  style={styles.deleteButton}
                  onPress={() => handleDeleteList(item.id)}
                >
                  <Text style={styles.deleteButtonText}>Delete</Text>
                </TouchableOpacity>
              </View>
            </TouchableOpacity>
          </View>
        )}
      />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    padding: 16,
    backgroundColor: '#f5f5f5'
  },
  welcome: {
    fontSize: 24,
    fontWeight: 'bold',
    marginBottom: 20,
    color: '#333'
  },
  inputContainer: {
    flexDirection: 'row',
    marginBottom: 20,
    alignItems: 'center'
  },
  input: {
    flex: 1,
    height: 50,
    borderWidth: 1,
    borderColor: '#ddd',
    borderRadius: 8,
    paddingHorizontal: 15,
    marginRight: 10,
    backgroundColor: 'white'
  },
  createButton: {
    backgroundColor: '#2196f3',
    paddingHorizontal: 20,
    paddingVertical: 12,
    borderRadius: 8
  },
  createButtonText: {
    color: 'white',
    fontWeight: 'bold'
  },
  listItem: {
    marginBottom: 10,
    borderRadius: 8,
    backgroundColor: 'white',
    elevation: 2,
    shadowColor: '#000',
    shadowOffset: { width: 0, height: 1 },
    shadowOpacity: 0.2,
    shadowRadius: 2
  },
  listTouchable: {
    padding: 16
  },
  listContent: {
    flexDirection: 'row',
    justifyContent: 'space-between',
    alignItems: 'center'
  },
  listTitle: {
    fontSize: 18,
    color: '#333',
    flex: 1
  },
  deleteButton: {
    backgroundColor: '#ff4444',
    paddingHorizontal: 15,
    paddingVertical: 8,
    borderRadius: 6
  },
  deleteButtonText: {
    color: 'white',
    fontWeight: 'bold'
  }
});