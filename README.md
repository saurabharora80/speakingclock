## Welcome to the Platform Development Coding Test

### Introduction

You have to write one small program in Java. Your delivered result should be compilable and runnable. Furthermore, it is important to deliver simple and elegant object oriented code. Apply a design pattern where it benefits the elegance of your code. Don’t apply it if it does not. 

There is no time limit, but please don't spend more than a couple of days on it. Don’t worry about writing GUIs. Spend the time on coming up with a good, simple design. The idea behind the test is to give you a chance to show us your idea of the 'perfect' solution.

### Requirements

* [Java 8/11 JDK](https://adoptopenjdk.net/upstream.html)

### Task
programming exercise: Speaking clock

Your company is writing the firmware for an alarm clock which will speak the time, so it can be used in the night and for people with visual disabilities.  The hardware contains a speech synthesiser, which will read out textual input.

You have been asked to write the software to convert a system time into the full text in English, as in the examples below.

| System Time |   English|
| ---------   | -------- |
|00:00 |          midnight|
|00:12	|	twelve twelve in the morning|
|08:34 |          eight thirty four in the morning|
|12:00      |     midday|
|15:04 |          three oh four in the afternoon|
|21:00  |         nine o'clock in the evening|

## Testing 

`mvn clean test`

## Building & Running Instructions

`mvn clean compile package && java -jar target/speakingclock-1.0.0-SNAPSHOT.jar`



