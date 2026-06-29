import React, { useState, useContext, useEffect } from "react";
import { StyleSheet, View, TextInput, Button, Text, FlatList } from 'react-native';
import { TokenContext, UsernameContext } from '../Context/Context';
import { createTodo, getTodos, updateTodo, deleteTodo } from '../components/todo';
import TodoItem from './TodoItem';

export default function TodoList({ route }) {
  const { todoListId } = route.params;
  const [token] = useContext(TokenContext);
  const [username] = useContext(UsernameContext);

  const [todos, setTodos] = useState([]);
  const [displayTodos, setDisplayTodos] = useState([]);
  const [newTodoText, setNewTodoText] = useState('');
  const [counterDone, setCounterDone] = useState(0);

  useEffect(() => {
    fetchTodos();
  }, [todoListId]);

  const fetchTodos = async () => {
    try {
      const fetchedTodos = await getTodos(todoListId, token);
      setTodos(fetchedTodos);
      setDisplayTodos(fetchedTodos);
      setCounterDone(fetchedTodos.filter(item => item.done).length);
    } catch (error) {
      console.error('Failed to fetch todos:', error);
    }
  };

  const addNewTodo = async () => {
    if (newTodoText.trim() === '') return;

    try {
      const newTodo = await createTodo(newTodoText, todoListId, token);
      const updatedTodos = [...todos, newTodo];
      setTodos(updatedTodos);
      setDisplayTodos(updatedTodos);
      setNewTodoText('');
      setCounterDone(updatedTodos.filter(item => item.done).length);
    } catch (error) {
      console.error('Failed to create todo:', error);
    }
  };

  const toggleSwitch2 = async (id) => {
    const todoToUpdate = todos.find(item => item.id === id);
    if (!todoToUpdate) return;

    try {
      const updatedTodo = await updateTodo(id, !todoToUpdate.done, token);
      const updatedTodos = todos.map(item => 
        item.id === id ? updatedTodo : item
      );
      setTodos(updatedTodos);
      setDisplayTodos(updatedTodos);
      setCounterDone(updatedTodos.filter(item => item.done).length);
    } catch (error) {
      console.error('Failed to update todo:', error);
    }
  };

  const deleteTodoItem = async (id) => {
    try {
      await deleteTodo(id, token);
      const updatedTodos = todos.filter(item => item.id !== id);
      setTodos(updatedTodos);
      setDisplayTodos(updatedTodos);
      setCounterDone(updatedTodos.filter(item => item.done).length);
    } catch (error) {
      console.error('Failed to delete todo:', error);
    }
  };

  const printTasksDone = () => {
    const doneTasks = todos.filter(item => item.done);
    setDisplayTodos(doneTasks);
  };

  const printTasksNotDone = () => {
    const undoneTasks = todos.filter(item => !item.done);
    setDisplayTodos(undoneTasks);
  };

  const printAllTasks = () => {
    setDisplayTodos(todos);
  };

  const CheckAllTasks = async () => {
    try {
      const updatePromises = todos
        .filter(item => !item.done)
        .map(item => updateTodo(item.id, true, token));
      
      await Promise.all(updatePromises);
      const updatedTodos = todos.map(item => ({ ...item, done: true }));
      setTodos(updatedTodos);
      setDisplayTodos(updatedTodos);
      setCounterDone(updatedTodos.length);
    } catch (error) {
      console.error('Failed to check all tasks:', error);
    }
  };

  const UnCheckAllTasks = async () => {
    try {
      const updatePromises = todos
        .filter(item => item.done)
        .map(item => updateTodo(item.id, false, token));
      
      await Promise.all(updatePromises);
      const updatedTodos = todos.map(item => ({ ...item, done: false }));
      setTodos(updatedTodos);
      setDisplayTodos(updatedTodos);
      setCounterDone(0);
    } catch (error) {
      console.error('Failed to uncheck all tasks:', error);
    }
  };

  return (
    <View>
      <Text>Task done: {counterDone}</Text>
      <Text style={{marginTop:10}}>Progress bar :</Text>
      <View style={{ height: 10, backgroundColor: '#ddd', borderRadius: 5,
         overflow: 'hidden', marginVertical: 10 }}>
        <View
            style={{
              height: '100%',
              width: `${todos.length ? (counterDone / todos.length) * 100: 0}%`,
              backgroundColor: 'red',
            }}
          />
        </View>
      <View style={styles.textInput_group}>
        <View>
          <TextInput
            style={styles.textinput_view}
            onChangeText={setNewTodoText}
            placeholder='Enter a new task'
            onSubmitEditing={addNewTodo}
            value={newTodoText}
          />
        </View>
        <View style={styles.buttoninput_view}>
          <Button onPress={addNewTodo} title='New' />
        </View>

        <View style={styles.buttoninput_view}>
          <Button onPress={printTasksDone} title='Done' />
        </View>
        <View style={styles.buttoninput_view}>
          <Button onPress={printTasksNotDone} title='Not Done' />
        </View>
        <View style={styles.buttoninput_view}>
          <Button onPress={printAllTasks} title='All' />
        </View>
        <View style={styles.buttoninput_view}>
          <Button onPress={CheckAllTasks} title='Check All' />
        </View>
        <View style={styles.buttoninput_view}>
          <Button onPress={UnCheckAllTasks} title='Uncheck All' />
        </View>
      </View>
      <FlatList
        style={{ paddingLeft: 10 }}
        data={displayTodos}
        renderItem={({item}) => (
          <TodoItem 
            item={item} 
            funcSwitch={toggleSwitch2}
            deleteTodo={deleteTodoItem} 
          />
        )}
        keyExtractor={(item) => item.id.toString()}
      />
    </View>
  );
}

const styles = StyleSheet.create({
  textInput_group: {
    flexDirection: 'row'
  },
  textinput_view: {
    margin: 12,
    borderWidth: 1,
    padding: 10
  },
  buttoninput_view: {
    margin: 12,
    paddingTop: 3
  }
});