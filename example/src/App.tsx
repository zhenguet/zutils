import * as React from 'react';

import { StyleSheet, View, Text, Button } from 'react-native';
import { createCalendarEvent, multiply, removeVietnameseTones } from 'zutils';

export default function App() {
  const [result, setResult] = React.useState<number | undefined>();

  React.useEffect(() => {
    multiply(3, 7).then(setResult);
  }, []);

  return (
    <View style={styles.container}>
      <Text>Result: {result}</Text>
      <Text>check: {removeVietnameseTones('Thử xem sao', false)}</Text>
      <Button
        title="check"
        onPress={() => {
          createCalendarEvent(
            'Party',
            'My House',
            (error: any, eventId: number) => {
              if (error) {
                console.error(`Error found! ${error}`);
              }
              console.log(`event id ${eventId} returned`);
            }
          );
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
