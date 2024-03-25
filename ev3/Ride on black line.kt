import ev3dev.actuators.lego.motors.EV3LargeRegulatedMotor
import ev3dev.sensors.ev3.EV3ColorSensor
import ev3dev.actuators.lego.motors.Motor
import ev3dev.sensors.ev3.EV3ColorSensor.MODE_COL_REFLECT
import lejos.hardware.port.MotorPort
import lejos.hardware.port.SensorPort
import lejos.robotics.Color

fun main() {
    val leftMotor = EV3LargeRegulatedMotor(MotorPort.B)
    val rightMotor = EV3LargeRegulatedMotor(MotorPort.C)
    val colorSensor = EV3ColorSensor(SensorPort.S1)
    colorSensor.mode = MODE_COL_REFLECT

    val turningSpeed = 50
    val forwardSpeed = 100

    fun moveForward() {
        leftMotor.speed = forwardSpeed
        rightMotor.speed = forwardSpeed
        leftMotor.forward()
        rightMotor.forward()
    }

    fun turnLeft() {
        leftMotor.speed = -turningSpeed
        rightMotor.speed = turningSpeed
        leftMotor.forward()
        rightMotor.forward()
    }

    fun turnRight() {
        leftMotor.speed = turningSpeed
        rightMotor.speed = -turningSpeed
        leftMotor.forward()
        rightMotor.forward()
    }

    while (true) {
        if (colorSensor.red < 30 && colorSensor.green < 30 && colorSensor.blue < 30) {
            moveForward()
        } else {
            if (colorSensor.red < 30) {
                turnLeft()
            } else {
                turnRight()
            }
        }
        Thread.sleep(100)
    }
}
