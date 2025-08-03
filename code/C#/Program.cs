var channel = Channel.CreateUnbounded<int>();
// Producer
_ = Task.Run(async () => {
    for (int i = 0; i < 5; i++)
    {
        await channel.Writer.WriteAsync(i);
        Console.WriteLine($"Sent: {i}");
    }
    channel.Writer.Complete();
});

// Consumer
await foreach (var item in channel.Reader.ReadAllAsync()) {
    Console.WriteLine($"Received: {item}");
}