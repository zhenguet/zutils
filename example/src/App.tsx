import React, { useEffect, useState } from 'react';

import { getCurrentDate } from '@zhenguet/zutils';
import { Button, StyleSheet, Text, View } from 'react-native';

export default function App() {
  const [date, setDate] = useState('');

  useEffect(() => {
    setInterval(() => {
      getCurrentDate((error: any, result: any) => setDate(result));
    }, 1000);
  }, [getCurrentDate]);

  return (
    <View style={styles.container}>
      <Text>{date}</Text>
      <Button
        title="check"
        onPress={() => {
          getCurrentDate((error: any, result: any) => console.log(result));
        }}
      />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  box: {
    width: 60,
    height: 60,
    marginVertical: 20,
  },
});
