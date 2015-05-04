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
import javafx.application.Application;
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
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.ArcToBuilder;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CircleBuilder;
import javafx.scene.shape.ClosePath;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.PathBuilder;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Nicolás
 */
public class Planetas extends Application {

    final int width = 1024;
    final int height = 800;
    PathTransition pathMercurio, pathSMercurio, pathVenus, pathSVenus, pathTierra, pathSTierra, pathMarte, pathSMarte;
    Path path;
    Stage solPlaneta;

    @Override
    public void start(final Stage primaryStage) {

        final Circle sol = CircleBuilder.create()
                .radius(70)
                .centerX(width / 2)
                .centerY(height / 2)
                .fill(new ImagePattern(new Image("images/sol.png")))
                .build();

        final Circle mercurio = CircleBuilder.create()
                .radius(10)
                .centerX(width / 2)
                .centerY(height / 2)
                .fill(new ImagePattern(new Image("images/mercurio.png")))
                .build();

        path = createEllipsePath((width / 2) + 100, height / 2, 100, 100);

        pathMercurio = PathTransitionBuilder.create()
                .duration(Duration.seconds(3))
                .path(path)
                .node(mercurio)
                .interpolator(Interpolator.LINEAR)
                .orientation(OrientationType.ORTHOGONAL_TO_TANGENT)
                .cycleCount(Timeline.INDEFINITE)
                .autoReverse(false)
                .build();

        pathMercurio.play();
        
        final Circle sMercurio = CircleBuilder.create()
                .radius(10)
                .centerX(width / 2)
                .centerY(height / 2)
                .fill(new ImagePattern(new Image("images/sombra.png")))
                .build();

        path = createEllipsePath((width / 2) + 100, height / 2, 100, 100);

        pathSMercurio = PathTransitionBuilder.create()
                .duration(Duration.seconds(3))
                .path(path)
                .node(sMercurio)
                .interpolator(Interpolator.LINEAR)
                .orientation(OrientationType.ORTHOGONAL_TO_TANGENT)
                .cycleCount(Timeline.INDEFINITE)
                .autoReverse(false)
                .build();

        pathSMercurio.play();

        final Circle venus = CircleBuilder.create()
                .radius(20)
                .centerX(width / 2)
                .centerY(height / 2)
                .fill(new ImagePattern(new Image("images/venus.png")))
                .build();

        path = createEllipsePath((width / 2) + 150, height / 2, 150, 150);

        pathVenus = PathTransitionBuilder.create()
                .duration(Duration.seconds(4))
                .path(path)
                .node(venus)
                .interpolator(Interpolator.LINEAR)
                .orientation(OrientationType.ORTHOGONAL_TO_TANGENT)
                .cycleCount(Timeline.INDEFINITE)
                .autoReverse(false)
                .build();

        pathVenus.play();
        
        final Circle sVenus = CircleBuilder.create()
                .radius(20)
                .centerX(width / 2)
                .centerY(height / 2)
                .fill(new ImagePattern(new Image("images/sombra.png")))
                .build();

        path = createEllipsePath((width / 2) + 150, height / 2, 150, 150);

        pathSVenus = PathTransitionBuilder.create()
                .duration(Duration.seconds(4))
                .path(path)
                .node(sVenus)
                .interpolator(Interpolator.LINEAR)
                .orientation(OrientationType.ORTHOGONAL_TO_TANGENT)
                .cycleCount(Timeline.INDEFINITE)
                .autoReverse(false)
                .build();

        pathSVenus.play();

        final Circle tierra = CircleBuilder.create()
                .radius(30)
                .centerX(width / 2)
                .centerY(height / 2)
                .fill(new ImagePattern(new Image("images/tierra.png")))
                .build();

        path = createEllipsePath((width / 2) + 250, height / 2, 250, 250);

        pathTierra = PathTransitionBuilder.create()
                .duration(Duration.seconds(5))
                .path(path)
                .node(tierra)
                .interpolator(Interpolator.LINEAR)
                .orientation(OrientationType.ORTHOGONAL_TO_TANGENT)
                .cycleCount(Timeline.INDEFINITE)
                .autoReverse(false)
                .build();

        pathTierra.play();
        
        final Circle sTierra = CircleBuilder.create()
                .radius(30)
                .centerX(width / 2)
                .centerY(height / 2)
                .fill(new ImagePattern(new Image("images/sombra.png")))
                .build();

        path = createEllipsePath((width / 2) + 250, height / 2, 250, 250);

        pathSTierra = PathTransitionBuilder.create()
                .duration(Duration.seconds(5))
                .path(path)
                .node(sTierra)
                .interpolator(Interpolator.LINEAR)
                .orientation(OrientationType.ORTHOGONAL_TO_TANGENT)
                .cycleCount(Timeline.INDEFINITE)
                .autoReverse(false)
                .build();

        pathSTierra.play();

        final Circle marte = CircleBuilder.create()
                .radius(15)
                .centerX(width / 2)
                .centerY(height / 2)
                .fill(new ImagePattern(new Image("images/marte.png")))
                .build();

        path = createEllipsePath((width / 2) + 350, height / 2, 350, 350);

        pathMarte = PathTransitionBuilder.create()
                .duration(Duration.seconds(6))
                .path(path)
                .node(marte)
                .interpolator(Interpolator.LINEAR)
                .orientation(OrientationType.ORTHOGONAL_TO_TANGENT)
                .cycleCount(Timeline.INDEFINITE)
                .autoReverse(false)
                .build();

        pathMarte.play();
        
        final Circle sMarte = CircleBuilder.create()
                .radius(15)
                .centerX(width / 2)
                .centerY(height / 2)
                .fill(new ImagePattern(new Image("images/sombra.png")))
                .build();

        path = createEllipsePath((width / 2) + 350, height / 2, 350, 350);

        pathSMarte = PathTransitionBuilder.create()
                .duration(Duration.seconds(6))
                .path(path)
                .node(sMarte)
                .interpolator(Interpolator.LINEAR)
                .orientation(OrientationType.ORTHOGONAL_TO_TANGENT)
                .cycleCount(Timeline.INDEFINITE)
                .autoReverse(false)
                .build();

        pathSMarte.play();
        
        Button solMercurio = ButtonBuilder.create()
                            .alignment(Pos.CENTER)
                            .text("Sol - Mercurio")
                            .build();
        
        solMercurio.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                solPlaneta = new Planeta(primaryStage, 1);
                solPlaneta.sizeToScene();
                solPlaneta.show();
            }
        });
        
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
        
        Button solVenus = ButtonBuilder.create()
                            .alignment(Pos.CENTER)
                            .text("Sol - Venus")
                            .build();
        
        solVenus.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                solPlaneta = new Planeta(primaryStage, 2);
                solPlaneta.show();
            }
        });
        
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
        
        Button solTierra = ButtonBuilder.create()
                            .alignment(Pos.CENTER)
                            .text("Sol - Tierra")
                            .build();
        
        solTierra.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                solPlaneta = new Planeta(primaryStage, 3);
                solPlaneta.show();
            }
        });
        
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
        
        Button solMarte = ButtonBuilder.create()
                            .alignment(Pos.CENTER)
                            .text("Sol - Marte")
                            .build();
        
        solMarte.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                solPlaneta = new Planeta(primaryStage, 4);
                solPlaneta.show();
            }
        });
        
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

        HBox botonera = HBoxBuilder.create()
                .alignment(Pos.BOTTOM_CENTER)
                .padding(new Insets(0, 100, 0, 100))
                .children(
                    VBoxBuilder.create()
                    .children(
                        solMercurio,
                        HBoxBuilder.create()
                            .padding(new Insets(10))
                            .children(
                                mercurioPlay,
                                mercurioPause,
                                mercurioStop
                            )
                            .build()
                    )
                    .build(),
                    VBoxBuilder.create()
                    .children(
                        solVenus,
                        HBoxBuilder.create()
                            .padding(new Insets(10))
                            .children(
                                venusPlay,
                                venusPause,
                                venusStop
                            )
                            .build()
                    )
                    .build(),
                    VBoxBuilder.create()
                    .children(
                        solTierra,
                        HBoxBuilder.create()
                            .padding(new Insets(10))
                            .children(
                                tierraPlay,
                                tierraPause,
                                tierraStop
                            )
                            .build()
                    )
                    .build(),
                    VBoxBuilder.create()
                    .children(
                        solMarte,
                        HBoxBuilder.create()
                            .padding(new Insets(10))
                            .children(
                                martePlay,
                                martePause,
                                marteStop
                            )
                            .build()
                    )
                    .build()
                )
                .spacing(100)
                .build();

        Scene scene = SceneBuilder.create()
                .fill(new ImagePattern(new Image("images/space.jpg")))
                .width(width)
                .height(height)
                .root(GroupBuilder.create()
                .children(sol, mercurio, sMercurio, venus, sVenus, tierra, sTierra, marte, sMarte, botonera).build()).build();

        primaryStage.setTitle("Planetas");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    static Path createEllipsePath(double centerX, double centerY, double radiusX, double radiusY) {
        ArcTo arcTo = ArcToBuilder.create()
                .x(centerX - radiusX + 1)
                .y(centerY - radiusY)
                .sweepFlag(false)
                .largeArcFlag(true)
                .radiusX(radiusX)
                .radiusY(radiusY)
                .build();

        return PathBuilder.create()
                .elements(
                new MoveTo(centerX - radiusX, centerY - radiusY),
                arcTo,
                new ClosePath())
                .build();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
