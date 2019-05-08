//package model;
//
//import javax.media.j3d.*;
//import javax.swing.*;
//import javax.vecmath.Point3d;
//import javax.vecmath.Vector3f;
//import java.awt.event.*;
//
//public class DogAnimation extends KeyAdapter implements ActionListener {
//
//    private static final float DELTA_DISTANCE = 0.02f;
//    private static final float DELTA_ANGLE = 0.05f;
//
//    private Spider Spider;
//    private TransformGroup DogTransformGroup;
//    private Transform3D transform3D = new Transform3D();
//
//    private float xLoc = 0;
//    private float yLoc = 0;
//
//    private float xAngle = 0;
//    private float yAngle = 0;
//    private float zAngle = 0;
//
//
//    private boolean resetXRotation = false;
//    private boolean resetYRotation = false;
//    private boolean resetZRotation = false;
//
//    private boolean isRotatedPosY = false;
//    private boolean isRotatedNegY = false;
//
//
//    private boolean isPressedW = false;
//    private boolean isPressedS = false;
//    private boolean isPressedA = false;
//    private boolean isPressedD = false;
//    private boolean isPressedVKRight = false;
//    private boolean isPressedVKLeft = false;
//    private boolean isPressedVKUp = false;
//    private boolean isPressedVKDown = false;
//
//    // ANIMATION -------------------------------------------------------------------------
//    int noRotHour = 100; //кількість обертів
//    int timeRotationHour = 300;//час одного оберту
//
//    BoundingSphere bs = new BoundingSphere(new Point3d(0.0,0.0,0.0),Double.MAX_VALUE);
//
//    // leg1_1 ---------------------------------------
//    int timeStart = 0;
//
//    Alpha leg1_1RotAlpha = new Alpha(noRotHour,Alpha.INCREASING_ENABLE,timeStart,0,timeRotationHour,
//            0,0,0,0,0);
//
//    Shape3D leg1_1 = (Shape3D) roachNamedObjects.get("leg1");
//    TransformGroup tgLeg1_1 = new TransformGroup();
//        tgLeg1_1.addChild(leg1_1.cloneTree());
//
//    Transform3D legRotAxis = new Transform3D();
//        legRotAxis.rotZ(Math.PI/2);
//
//    RotationInterpolator leg1_1Rotation = new RotationInterpolator(leg1_1RotAlpha,tgLeg1_1,legRotAxis,(float) Math.PI/2,0.0f);
//        leg1_1Rotation.setSchedulingBounds(bs);
//        tgLeg1_1.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
//        tgLeg1_1.addChild(leg1_1Rotation);
//    //----------------------------------------------------
//
//    // leg2_1 ---------------------------------------
//    Alpha leg2_1RotAlpha = new Alpha(noRotHour,Alpha.INCREASING_ENABLE,100,0,timeRotationHour,
//            0,0,0,0,0);
//
//    Shape3D leg2_1 = (Shape3D) roachNamedObjects.get("leg2");
//    TransformGroup tgLeg2_1 = new TransformGroup();
//        tgLeg2_1.addChild(leg2_1.cloneTree());
//
//    Transform3D leg2RotAxis = new Transform3D();
//
//    RotationInterpolator leg2_1Rotation = new RotationInterpolator(leg2_1RotAlpha,tgLeg2_1,leg2RotAxis,(float) Math.PI/8,0.0f);
//        leg2_1Rotation.setSchedulingBounds(bs);
//        tgLeg2_1.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
//        tgLeg2_1.addChild(leg2_1Rotation);
//    //----------------------------------------------------
//
//    // leg3_1 ---------------------------------------
//    Alpha leg3_1RotAlpha = new Alpha(noRotHour,Alpha.INCREASING_ENABLE,200,0,timeRotationHour,
//            0,0,0,0,0);
//
//    Shape3D leg3_1 = (Shape3D) roachNamedObjects.get("leg3");
//    TransformGroup tgLeg3_1 = new TransformGroup();
//        tgLeg3_1.addChild(leg3_1.cloneTree());
//
//
//    RotationInterpolator leg3_1Rotation = new RotationInterpolator(leg3_1RotAlpha,tgLeg3_1,leg2RotAxis,(float) Math.PI/8,0.0f);
//        leg3_1Rotation.setSchedulingBounds(bs);
//        tgLeg3_1.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
//        tgLeg3_1.addChild(leg3_1Rotation);
//    //----------------------------------------------------
//
//    // leg4_1 ---------------------------------------
//    Alpha leg4_1RotAlpha = new Alpha(noRotHour,Alpha.INCREASING_ENABLE,300,0,timeRotationHour,
//            0,0,0,0,0);
//
//    Shape3D leg4_1 = (Shape3D) roachNamedObjects.get("leg4");
//    TransformGroup tgLeg4_1 = new TransformGroup();
//        tgLeg4_1.addChild(leg4_1.cloneTree());
//
//    RotationInterpolator leg4_1Rotation = new RotationInterpolator(leg4_1RotAlpha,tgLeg4_1,leg2RotAxis,(float) Math.PI/8,0.0f);
//        leg4_1Rotation.setSchedulingBounds(bs);
//        tgLeg4_1.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
//        tgLeg4_1.addChild(leg4_1Rotation);
//    //----------------------------------------------------
//
//    // leg1_2 ---------------------------------------
//
//    Alpha leg1_2RotAlpha = new Alpha(noRotHour,Alpha.INCREASING_ENABLE,200,0,timeRotationHour,
//            0,0,0,0,0);
//
//    Shape3D leg1_2 = (Shape3D) roachNamedObjects.get("leg8");
//    TransformGroup tgLeg1_2 = new TransformGroup();
//        tgLeg1_2.addChild(leg1_2.cloneTree());
//    ;
//
//    RotationInterpolator leg1_2Rotation = new RotationInterpolator(leg1_2RotAlpha,tgLeg1_2,legRotAxis,(float) Math.PI/2,0.0f);
//        leg1_2Rotation.setSchedulingBounds(bs);
//        tgLeg1_2.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
//        tgLeg1_2.addChild(leg1_2Rotation);
//    //----------------------------------------------------
//
//    // leg2_2 ---------------------------------------
//    Alpha leg2_2RotAlpha = new Alpha(noRotHour,Alpha.INCREASING_ENABLE,300,0,timeRotationHour,
//            0,0,0,0,0);
//
//    Shape3D leg2_2 = (Shape3D) roachNamedObjects.get("leg7");
//    TransformGroup tgLeg2_2 = new TransformGroup();
//        tgLeg2_2.addChild(leg2_2.cloneTree());
//
//    RotationInterpolator leg2_2Rotation = new RotationInterpolator(leg2_2RotAlpha,tgLeg2_2,leg2RotAxis,-(float) Math.PI/8,0.0f);
//        leg2_2Rotation.setSchedulingBounds(bs);
//        tgLeg2_2.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
//        tgLeg2_2.addChild(leg2_2Rotation);
//    //----------------------------------------------------
//
//    // leg3_2 ---------------------------------------
//    Alpha leg3_2RotAlpha = new Alpha(noRotHour,Alpha.INCREASING_ENABLE,400,0,timeRotationHour,
//            0,0,0,0,0);
//
//    Shape3D leg3_2 = (Shape3D) roachNamedObjects.get("leg6");
//    TransformGroup tgLeg3_2 = new TransformGroup();
//        tgLeg3_2.addChild(leg3_2.cloneTree());
//
//
//    RotationInterpolator leg3_2Rotation = new RotationInterpolator(leg3_2RotAlpha,tgLeg3_2,leg2RotAxis,-(float) Math.PI/8,0.0f);
//        leg3_2Rotation.setSchedulingBounds(bs);
//        tgLeg3_2.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
//        tgLeg3_2.addChild(leg3_2Rotation);
//    //----------------------------------------------------
//
//    // leg4_2 ---------------------------------------
//    Alpha leg4_2RotAlpha = new Alpha(noRotHour,Alpha.INCREASING_ENABLE,500,0,timeRotationHour,
//            0,0,0,0,0);
//
//    Shape3D leg4_2 = (Shape3D) roachNamedObjects.get("leg5");
//    TransformGroup tgLeg4_2 = new TransformGroup();
//        tgLeg4_2.addChild(leg4_2.cloneTree());
//
//    RotationInterpolator leg4_2Rotation = new RotationInterpolator(leg4_2RotAlpha,tgLeg4_2,leg2RotAxis,-(float) Math.PI/8,0.0f);
//        leg4_2Rotation.setSchedulingBounds(bs);
//        tgLeg4_2.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
//        tgLeg4_2.addChild(leg4_2Rotation);
//    //----------------------------------------------------
//
//
//        sceneGroup.addChild(tgLeg1_1);
//        sceneGroup.addChild(tgLeg2_1);
//        sceneGroup.addChild(tgLeg3_1);
//        sceneGroup.addChild(tgLeg4_1);
//
//        sceneGroup.addChild(tgLeg1_2);
//        sceneGroup.addChild(tgLeg2_2);
//        sceneGroup.addChild(tgLeg3_2);
//        sceneGroup.addChild(tgLeg4_2);
//
//
//
//        sceneGroup.addChild(tgBody.cloneTree());
//
//
//    // movement widow --------------------------------------------------------
//    Transform3D tCrawl = new Transform3D();
//        tCrawl.rotY(-Math.PI/2);
//
//    long crawlTime = 10000;
//    Alpha crawlAlpha = new Alpha(1,
//            Alpha.INCREASING_ENABLE,
//            0,
//            0, crawlTime,0,0,0,0,0);
//
//    float crawlDistance = 9.0f; //відстань, на яку просунеться об’єкт
//    PositionInterpolator posICrawl = new PositionInterpolator(crawlAlpha,
//            sceneGroup,tCrawl, -9.0f, crawlDistance);
//
//        posICrawl.setSchedulingBounds(bs);
//        sceneGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
//        sceneGroup.addChild(posICrawl);
//
////        Transform3D tCrawl2 = new Transform3D();
////        tCrawl2.rotZ(Math.PI/2);
////        RotationInterpolator testRot = new RotationInterpolator(crawlAlpha,sceneGroup,tCrawl2,(float) Math.PI/2,0.0f);
////        testRot.setSchedulingBounds(bs);
////        sceneGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
////        sceneGroup.addChild(testRot);
//    //-------------------------------------------------------------------------
//
//        tgRoach.addChild(sceneGroup);
//        theScene.addChild(tgRoach);
//
//    //------------------------------------------------------------------------------------------------------
//
//
//    private void Move() {
//        if (isPressedW) {
//            yLoc += DELTA_DISTANCE;
//        }
//
//        if (isPressedS) {
//            yLoc -= DELTA_DISTANCE;
//        }
//
//        if (isPressedA) {
//            xLoc -= DELTA_DISTANCE;
//        }
//
//        if (isPressedD) {
//            xLoc += DELTA_DISTANCE;
//        }
//
//        transform3D.setTranslation(new Vector3f(xLoc, yLoc, 0));
//
//        if (isPressedVKRight) {
//            Transform3D rotation = new Transform3D();
//            rotation.rotZ(DELTA_ANGLE);
//            zAngle += DELTA_ANGLE;
//            transform3D.mul(rotation);
//
//        }
//
//        if (isPressedVKLeft) {
//            Transform3D rotation = new Transform3D();
//            rotation.rotZ(-DELTA_ANGLE);
//            zAngle -= DELTA_ANGLE;
//            transform3D.mul(rotation);
//        }
//
//        if (isPressedVKUp) {
//            Transform3D rotation = new Transform3D();
//            rotation.rotX(-DELTA_ANGLE);
//            xAngle -= DELTA_ANGLE;
//            transform3D.mul(rotation);
//        }
//
//        if (isPressedVKDown) {
//            Transform3D rotation = new Transform3D();
//            rotation.rotX(DELTA_ANGLE);
//            xAngle += DELTA_ANGLE;
//            transform3D.mul(rotation);
//        }
//
//        if (isRotatedPosY) {
//            Transform3D rotation = new Transform3D();
//            rotation.rotY(degree(20));
//            transform3D.mul(rotation);
//
//            yAngle += degree(20);
//
//            isRotatedPosY = false;
//        }
//
//        if (isRotatedNegY) {
//            Transform3D rotation = new Transform3D();
//            rotation.rotY(degree(-20));
//            transform3D.mul(rotation);
//
//            yAngle += degree(-20);
//
//            isRotatedNegY = false;
//        }
//
//        if (resetYRotation) {
//            Transform3D rotation = new Transform3D();
//            rotation.rotY(-yAngle);
//            transform3D.mul(rotation);
//
//            resetYRotation = false;
//            yAngle = 0;
//        }
//
//        if (resetZRotation) {
//            Transform3D rotation = new Transform3D();
//            rotation.rotZ(-zAngle);
//            transform3D.mul(rotation);
//
//            resetZRotation = false;
//            zAngle = 0;
//        }
//
//        if (resetXRotation) {
//            Transform3D rotation = new Transform3D();
//            rotation.rotX(-xAngle);
//            transform3D.mul(rotation);
//
//            resetXRotation = false;
//            xAngle = 0;
//        }
//
//        DogTransformGroup.setTransform(transform3D);
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        Move();
//    }
//
//    @Override
//    public void keyPressed(KeyEvent ev) {
//        switch (ev.getKeyCode()) {
//            case 87: // W
//                isPressedW = true;
//                break;
//            case 83: // S
//                isPressedS = true;
//                break;
//            case 65: // A
//                if (!isPressedA) {
//                    isPressedA = true;
//                    isRotatedNegY = true;
//                }
//                break;
//            case 68: // D
//                if (!isPressedD) {
//                    isPressedD = true;
//                    isRotatedPosY = true;
//                }
//                break;
//            case KeyEvent.VK_LEFT:
//                isPressedVKLeft = true;
//                break;
//            case KeyEvent.VK_RIGHT:
//                isPressedVKRight = true;
//                break;
//
//            case KeyEvent.VK_UP:
//                isPressedVKUp = true;
//                break;
//            case KeyEvent.VK_DOWN:
//                isPressedVKDown = true;
//                break;
//            case 48: // 0
//                resetXRotation = true;
//                resetYRotation = true;
//                resetZRotation = true;
//                break;
//        }
//    }
//
//    @Override
//    public void keyReleased(KeyEvent ev) {
//        switch (ev.getKeyCode()) {
//            case 87: // W
//                isPressedW = false;
//                break;
//            case 83: // S
//                isPressedS = false;
//                break;
//            case 65: // A
//                isPressedA = false;
//                resetYRotation = true;
//                break;
//            case 68: // D
//                isPressedD = false;
//                resetYRotation = true;
//                break;
//            case KeyEvent.VK_RIGHT:
//                isPressedVKRight = false;
//                break;
//            case KeyEvent.VK_LEFT:
//                isPressedVKLeft = false;
//                break;
//            case KeyEvent.VK_UP:
//                isPressedVKUp = false;
//                break;
//            case KeyEvent.VK_DOWN:
//                isPressedVKDown = false;
//                break;
//        }
//    }
//
//    private float degree(float degrees) {
//        return (float) (degrees * Math.PI / 180);
//    }
//}
