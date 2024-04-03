import 'package:flutter/material.dart';
import 'package:method_channel_flutter/practice.dart';
class Home extends StatefulWidget {
  const Home({super.key});

  @override
  State<Home> createState() => _HomeState();
}

class _HomeState extends State<Home> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        actions: [
          TextButton(onPressed: () async{

            await PlatformRepository().changeColor("Formal Parameter color input");

          }, child: Text("Color Method")),
          TextButton(onPressed: () async{

            await PlatformRepository().openMaps();

          }, child: Text("Open Maps"))
        ],
      ),
    );
  }
}
