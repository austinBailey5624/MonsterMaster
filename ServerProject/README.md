## Abstract

### Purpose

The server project serves as the source of truth for items in all different variations of the monster master project. The intention is for there to be multiple different versions for different platforms in the future- all of their common knowledge should come from this folder

### ServerSetup.sql

This sets up the server with all of the raw required to make the game run that needs to be handled and massaged by each of the platforms to make the executable. This is a large file (obviously).

### GetTraits.sql

A utility method to retrieve tratis on a server that has already had ServerSetup.sql executed on it