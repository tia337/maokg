package examples;

import javax.media.j3d.BoundingSphere;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.DirectionalLight;
import javax.vecmath.Color3f;
import javax.vecmath.Point3d;
import javax.vecmath.Vector3f;
import com.sun.j3d.utils.geometry.Sphere;
import com.sun.j3d.utils.universe.SimpleUniverse;

public class Lighting {
    public static void main(String[] args) {
        new Lighting();
    }

    private Lighting()
    {
        SimpleUniverse universe = new SimpleUniverse();
        BranchGroup group = new BranchGroup();
        Sphere sphere = new Sphere(0.5f);
        group.addChild(sphere);

        // Створюємо зелене світло, яке світить з відстані 100м від об'єкту
        Color3f light1Color = new Color3f(0.8f, 1.1f, 0.1f); // параметри конструктор - це відповідно червона, зелена та синя компоненти кольору
        Vector3f light1Direction = new Vector3f(4.0f, -7.0f, -10.0f); //встановлюєм вектор, що задає напрям освітлення
        DirectionalLight light1 = new DirectionalLight(light1Color, light1Direction); //створюмо власне об'єкт освітлення

        BoundingSphere bounds =  new BoundingSphere(new Point3d(0.0, 0.0, 0.0),100.0); // вказуємо сферу, внутрішній простір якої буде освітлено
        light1.setInfluencingBounds(bounds); //вказуємо, яка частина сцени має бути освітлена

        group.addChild(light1); //додаємо освітлення ло сцени
        universe.getViewingPlatform().setNominalViewingTransform();
        universe.addBranchGraph(group);
    }
}
