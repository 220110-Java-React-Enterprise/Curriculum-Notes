## Publisher/Subscriber Design Pattern

The Publisher/Subscriber design pattern describes the flow of messages between applications, devices, or services. 

A message is published by **Publishers** to a **Channel**, that will be consumed by all **Subscribers** monitoring that channel. 

When the Publisher pushes messages to a channel (live-feed data streams), the subscribers who subscribed to this channel are immediately notified. Any publisher may also be a subscriber. Messages can be text, sensor data, audio, video, or other digital content.

The Pub-Sub pattern is usually implemented in an asynchronous way. In the Observer pattern the observers are aware of the observable, but in Pub-Sub pattern, publishers and subscribers don’t need to know each other. They simply communicate with the help of message queues.

![](./../images/pub-sub.png)

**Example - Pub-Sub pattern**
```typescript
class PubSub {
  constructor() {
    this.handlers = [];
  }

//publisher publishes the topic to the channel
  publish(event, args) {
    this.handlers.forEach(topic => {
      if (topic.event === event) {
        topic.handler(args)
      }
    })
  }

// subscriber gets notifications when there is a new feed in the subscribed channel
  subscribe(event, handler, context) {
    if (typeof context === 'undefined') { context = handler; }
    this.handlers.push({ event: event, handler: handler.bind(context) });
  }
}

export default new PubSub();
```
