#!/bin/bash

set -ue 

javac ./src/Main.java
jar cmvf ./src/META-INF/MANIFEST.MF ./MemTest.jar ./src/Main.class

