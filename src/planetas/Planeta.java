/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package planetas;

import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.animation.PathTransition.OrientationType;
import javafx.animation.PathTransitionBuilder;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.GroupBuilder;
import javafx.scene.Scene;
import javafx.scene.SceneBuilder;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBuilder;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.HBoxBuilder;
import javafx.scene.layout.VBoxBuilder;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CircleBuilder;
import javafx.scene.shape.Path;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import static planetas.Planetas.createEllipsePath;

/**
 *
 * @author Nicolás
 */
public class Planeta extends Stage {

    final int width = 1024;
    final int height = 900;
    PathTransition pathMercurio, pathSMercurio, pathVenus, pathSVenus, pathTierra, pathSTierra, pathMarte, pathSMarte;
    Circle sol, mercurio = null, sMercurio = null, venus = null, sVenus = null, tierra = null, sTierra = null, marte = null, sMarte = null;
    Path path;
    Scene scene;
    HBox botonera;

    public Planeta(final Stage stage, int planeta) {
        super();

        sol = CircleBuilder.create()
                .radius(210)
                .centerX(width / 2)
                .centerY(height / 2)
                .fill(new ImagePattern(new Image("images/sol.png")))
                .build();

        switch (planeta) {
            case 1:
                mercurio = CircleBuilder.create()
                        .radius(30)
                        .centerX(width / 2)
                        .centerY(height / 2)
                        .fill(new ImagePattern(new Image("images/mercurio.png")))
                        .build();

                path = Planetas.createEllipsePath((width / 2) + 350, height / 2, 350, 350);

                pathMercurio = PathTransitionBuilder.create()
                        .duration(Duration.seconds(10))
                        .path(path)
                        .node(mercurio)
                        .interpolator(Interpolator.LINEAR)
                        .orientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT)
                        .cycleCount(Timeline.INDEFINITE)
                        .autoReverse(false)
                        .build();

                pathMercurio.play();

                sMercurio = CircleBuilder.create()
                        .radius(30)
                        .centerX(width / 2)
                        .centerY(height / 2)
                        .fill(new ImagePattern(new Image("images/sombra.png")))
                        .build();

                path = createEllipsePath((width / 2) + 350, height / 2, 350, 350);

                pathSMercurio = PathTransitionBuilder.create()
                        .duration(Duration.seconds(10))
                        .path(path)
                        .node(sMercurio)
                        .interpolator(Interpolator.LINEAR)
                        .orientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT)
                        .cycleCount(Timeline.INDEFINITE)
                        .autoReverse(false)
                        .build();

                pathSMercurio.play();

                Button mercurioPlay = ButtonBuilder.create()
                        .alignment(Pos.BOTTOM_CENTER)
                        .text("Play")
                        .build();

                mercurioPlay.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent t) {
                        pathMercurio.play();
                        pathSMercurio.play();
                    }
                });

                Button mercurioPause = ButtonBuilder.create()
                        .alignment(Pos.BOTTOM_CENTER)
                        .text("Pause")
                        .build();

                mercurioPause.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent t) {
                        pathMercurio.pause();
                        pathSMercurio.pause();
                    }
                });

                Button mercurioStop = ButtonBuilder.create()
                        .alignment(Pos.BOTTOM_CENTER)
                        .text("Stop")
                        .build();

                mercurioStop.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent t) {
                        pathMercurio.stop();
                        pathSMercurio.stop();
                    }
                });

                botonera = HBoxBuilder.create()
                        .alignment(Pos.BOTTOM_CENTER)
                        .padding(new Insets(0, 100, 0, 100))
                        .children(
                        VBoxBuilder.create()
                        .children(
                        HBoxBuilder.create()
                        .padding(new Insets(10))
                        .children(
                        mercurioPlay,
                        mercurioPause,
                        mercurioStop)
                        .build())
                        .build())
                        .spacing(100)
                        .build();

                scene = SceneBuilder.create()
                        .fill(new ImagePattern(new Image("images/space.jpg")))
                        .width(width)
                        .height(height)
                        .root(GroupBuilder.create()
                        .children(sol, mercurio, sMercurio, botonera).build()).build();

                setTitle("Sol - Mercurio");

                break;
            case 2:
                venus = CircleBuilder.create()
                        .radius(60)
                        .centerX(width / 2)
                        .centerY(height / 2)
                        .fill(new ImagePattern(new Image("images/venus.png")))
                        .build();

                path = createEllipsePath((width / 2) + 350, height / 2, 350, 350);

                pathVenus = PathTransitionBuilder.create()
                        .duration(Duration.seconds(10))
                        .path(path)
                        .node(venus)
                        .interpolator(Interpolator.LINEAR)
                        .orientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT)
                        .cycleCount(Timeline.INDEFINITE)
                        .autoReverse(false)
                        .build();

                pathVenus.play();
                
                sVenus = CircleBuilder.create()
                        .radius(60)
                        .centerX(width / 2)
                        .centerY(height / 2)
                        .fill(new ImagePattern(new Image("images/sombra.png")))
                        .build();

                path = createEllipsePath((width / 2) + 350, height / 2, 350, 350);

                pathSVenus = PathTransitionBuilder.create()
                        .duration(Duration.seconds(10))
                        .path(path)
                        .node(sVenus)
                        .interpolator(Interpolator.LINEAR)
                        .orientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT)
                        .cycleCount(Timeline.INDEFINITE)
                        .autoReverse(false)
                        .build();

                pathSVenus.play();

                Button venusPlay = ButtonBuilder.create()
                        .alignment(Pos.BOTTOM_CENTER)
                        .text("Play")
                        .build();

                venusPlay.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent t) {
                        pathVenus.play();
                        pathSVenus.play();
                    }
                });

                Button venusPause = ButtonBuilder.create()
                        .alignment(Pos.BOTTOM_CENTER)
                        .text("Pause")
                        .build();

                venusPause.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent t) {
                        pathVenus.pause();
                        pathSVenus.pause();
                    }
                });

                Button venusStop = ButtonBuilder.create()
                        .alignment(Pos.BOTTOM_CENTER)
                        .text("Stop")
                        .build();

                venusStop.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent t) {
                        pathVenus.stop();
                        pathSVenus.stop();
                    }
                });

                botonera = HBoxBuilder.create()
                        .alignment(Pos.BOTTOM_CENTER)
                        .padding(new Insets(0, 100, 0, 100))
                        .children(
                        VBoxBuilder.create()
                        .children(
                        HBoxBuilder.create()
                        .padding(new Insets(10))
                        .children(
                        venusPlay,
                        venusPause,
                        venusStop)
                        .build())
                        .build())
                        .spacing(100)
                        .build();

                scene = SceneBuilder.create()
                        .fill(new ImagePattern(new Image("images/space.jpg")))
                        .width(width)
                        .height(height)
                        .root(GroupBuilder.create()
                        .children(sol, venus, sVenus, botonera).build()).build();

                setTitle("Sol - Venus");

                break;
            case 3:
                tierra = CircleBuilder.create()
                        .radius(90)
                        .centerX(width / 2)
                        .centerY(height / 2)
                        .fill(new ImagePattern(new Image("images/tierra.png")))
                        .build();

                path = createEllipsePath((width / 2) + 350, height / 2, 350, 350);

                pathTierra = PathTransitionBuilder.create()
                        .duration(Duration.seconds(10))
                        .path(path)
                        .node(tierra)
                        .interpolator(Interpolator.LINEAR)
                        .orientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT)
                        .cycleCount(Timeline.INDEFINITE)
                        .autoReverse(false)
                        .build();

                pathTierra.play();
                
                sTierra = CircleBuilder.create()
                        .radius(90)
                        .centerX(width / 2)
                        .centerY(height / 2)
                        .fill(new ImagePattern(new Image("images/sombra.png")))
                        .build();

                path = createEllipsePath((width / 2) + 350, height / 2, 350, 350);

                pathSTierra = PathTransitionBuilder.create()
                        .duration(Duration.seconds(10))
                        .path(path)
                        .node(sTierra)
                        .interpolator(Interpolator.LINEAR)
                        .orientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT)
                        .cycleCount(Timeline.INDEFINITE)
                        .autoReverse(false)
                        .build();

                pathSTierra.play();

                Button tierraPlay = ButtonBuilder.create()
                        .alignment(Pos.BOTTOM_CENTER)
                        .text("Play")
                        .build();

                tierraPlay.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent t) {
                        pathTierra.play();
                        pathSTierra.play();
                    }
                });

                Button tierraPause = ButtonBuilder.create()
                        .alignment(Pos.BOTTOM_CENTER)
                        .text("Pause")
                        .build();

                tierraPause.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent t) {
                        pathTierra.pause();
                        pathSTierra.pause();
                    }
                });

                Button tierraStop = ButtonBuilder.create()
                        .alignment(Pos.BOTTOM_CENTER)
                        .text("Stop")
                        .build();

                tierraStop.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent t) {
                        pathTierra.stop();
                        pathSTierra.stop();
                    }
                });

                botonera = HBoxBuilder.create()
                        .alignment(Pos.BOTTOM_CENTER)
                        .padding(new Insets(0, 100, 0, 100))
                        .children(
                        VBoxBuilder.create()
                        .children(
                        HBoxBuilder.create()
                        .padding(new Insets(10))
                        .children(
                        tierraPlay,
                        tierraPause,
                        tierraStop)
                        .build())
                        .build())
                        .spacing(100)
                        .build();

                scene = SceneBuilder.create()
                        .fill(new ImagePattern(new Image("images/space.jpg")))
                        .width(width)
                        .height(height)
                        .root(GroupBuilder.create()
                        .children(sol, tierra, sTierra, botonera).build()).build();

                setTitle("Sol - Tierra");

                break;
            case 4:
                marte = CircleBuilder.create()
                        .radius(45)
                        .centerX(width / 2)
                        .centerY(height / 2)
                        .fill(new ImagePattern(new Image("images/marte.png")))
                        .build();

                path = createEllipsePath((width / 2) + 350, height / 2, 350, 350);

                pathMarte = PathTransitionBuilder.create()
                        .duration(Duration.seconds(10))
                        .path(path)
                        .node(marte)
                        .interpolator(Interpolator.LINEAR)
                        .orientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT)
                        .cycleCount(Timeline.INDEFINITE)
                        .autoReverse(false)
                        .build();

                pathMarte.play();

                sMarte = CircleBuilder.create()
                        .radius(45)
                        .centerX(width / 2)
                        .centerY(height / 2)
                        .fill(new ImagePattern(new Image("images/sombra.png")))
                        .build();

                path = createEllipsePath((width / 2) + 350, height / 2, 350, 350);

                pathSMarte = PathTransitionBuilder.create()
                        .duration(Duration.seconds(10))
                        .path(path)
                        .node(sMarte)
                        .interpolator(Interpolator.LINEAR)
                        .orientation(OrientationType.ORTHOGONAL_TO_TANGENT)
                        .cycleCount(Timeline.INDEFINITE)
                        .autoReverse(false)
                        .build();

                pathSMarte.play();

                Button martePlay = ButtonBuilder.create()
                        .alignment(Pos.BOTTOM_CENTER)
                        .text("Play")
                        .build();

                martePlay.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent t) {
                        pathMarte.play();
                        pathSMarte.play();
                    }
                });

                Button martePause = ButtonBuilder.create()
                        .alignment(Pos.BOTTOM_CENTER)
                        .text("Pause")
                        .build();

                martePause.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent t) {
                        pathMarte.pause();
                        pathSMarte.pause();
                    }
                });

                Button marteStop = ButtonBuilder.create()
                        .alignment(Pos.BOTTOM_CENTER)
                        .text("Stop")
                        .build();

                marteStop.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent t) {
                        pathMarte.stop();
                        pathSMarte.stop();
                    }
                });

                botonera = HBoxBuilder.create()
                        .alignment(Pos.BOTTOM_CENTER)
                        .padding(new Insets(0, 100, 0, 100))
                        .children(
                        VBoxBuilder.create()
                        .children(
                        HBoxBuilder.create()
                        .padding(new Insets(10))
                        .children(
                        martePlay,
                        martePause,
                        marteStop)
                        .build())
                        .build())
                        .spacing(100)
                        .build();

                scene = SceneBuilder.create()
                        .fill(new ImagePattern(new Image("images/space.jpg")))
                        .width(width)
                        .height(height)
                        .root(GroupBuilder.create()
                        .children(sol, marte, sMarte, botonera).build()).build();

                setTitle("Sol - Marte");

                break;
        }

        initOwner(stage);
        initModality(Modality.APPLICATION_MODAL);
        setScene(scene);

    }
}
