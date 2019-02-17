package random

import javafx.application.Platform
import javafx.geometry.Pos
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.layout.VBox
import oolong.Render
import random.Random.Props
import tornadofx.View
import tornadofx.action
import tornadofx.button
import tornadofx.label

class RandomView : View() {

    override val root = VBox()

    private val faceLabel: Label
    private val rollButton: Button

    init {
        with(root) {
            setPrefSize(100.0, 150.0)
            alignment = Pos.CENTER
            spacing = 10.0

            faceLabel = label()
            rollButton = button("Roll")
        }
    }

    val render: Render<Props> = { props ->
        Platform.runLater {
            faceLabel.text = "${props.dieFace}"
            rollButton.action { props.onRoll() }
        }
    }

}