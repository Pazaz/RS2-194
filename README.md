# RS2-194

This targets revision 194, which came out on Jan 7 2004.  
Most of my effort is still on 225. I just wanted to put at least something out there for this early beta revision.

## Running

`./gradlew client:run --args='10 0 highmem'

If you want to run the original obfuscated client:  
`./gradlew server:run`
`java -cp ref/runescape.jar client 10 0 highmem`

## Deviations

- Patched one thing in PlayerEntity to prevent crashing... something about triangleAlpha being null on a body part. 225 had this null check but 194 did not. I suspect that something else is different that I'm not accounting for (sending a missing required body part?)
- Moved appearance/beard stuff from client to PlayerEntity to move it to the runetek3 module. This means I also had to pass a cycle parameter to MapSquare.draw, so it would reach PlayerEntity.
- Fixed the frame so it didn't use fixed offsets.
- Disabled ISAAC... nextInt() returns 0 because I didn't want to bother with the packet lengths.

## TODO

If anyone takes this up:  
- Rename the rest of the client (can reference RS2-225)
- Remove any remaining obfuscation (probably best to restart in OpenRS2, but it may not work with the transformers there).
- Identify all of the Server/Client packet opcodes and update them in ServerProt/ClientProt.
- Check out ref/linked-anims.txt, I generated a list of animations linked to entities based on skeletons.
