
 
const stompit = require('stompit');
 
stompit.connect({ 'client-id': 'node1', host: '192.168.0.100', port: 61613 }, (err, client) => {
 
  client.subscribe({ 'activemq.subscriptionName': 'node1', destination: '/topic/topico.ppdPubSub' }, (err, msg) => {
 
    msg.readString('UTF-8', (err, body) => {
      console.log(body);

    });
 
  });
 
});

  
  