package com.lanterns.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelSpider extends ModelBase
{
  //fields
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Shape5;
    ModelRenderer Shape6;
    ModelRenderer Shape7;
  
    public ModelSpider()
    {
      textureWidth = 64;
      textureHeight = 32;
      
      	//tail
        Shape1 = new ModelRenderer(this, 0, 4);
        Shape1.addBox(0F, 0F, 0F, 2, 2, 3);
        Shape1.setRotationPoint(-1F, 19F, 2F);
        Shape1.setTextureSize(64, 32);
        Shape1.mirror = true;
        setRotation(Shape1, 0F, 0F, 0F);
        
        //body
        Shape2 = new ModelRenderer(this, 0, 11);
        Shape2.addBox(0F, 0F, 0F, 1, 1, 1);
        Shape2.setRotationPoint(-0.5F, 19.5F, 1F);
        Shape2.setTextureSize(64, 32);
        Shape2.mirror = true;
        setRotation(Shape2, 0F, 0F, 0F);
        
        //Head
        Shape3 = new ModelRenderer(this, 0, 16);
        Shape3.addBox(0F, 0F, 0F, 2, 2, 2);
        Shape3.setRotationPoint(-1F, 19F, -1F);
        Shape3.setTextureSize(64, 32);
        Shape3.mirror = true;
        setRotation(Shape3, 0F, 0F, 0F);
        
        //leggs
        Shape4 = new ModelRenderer(this, 0, 0);
        Shape4.addBox(0.5F, 0F, 0F, 2, 1, 1);
        Shape4.setRotationPoint(0.5F, 19.5F, 1F);
        Shape4.setTextureSize(64, 32);
        Shape4.mirror = true;
        setRotation(Shape4, 0F, -0.4089647F, 0.3346075F);
        Shape5 = new ModelRenderer(this, 0, 0);
        Shape5.addBox(0.5F, 0F, 0F, 2, 1, 1);
        Shape5.setRotationPoint(-2.5F, 20.5F, -0.5F);
        Shape5.setTextureSize(64, 32);
        Shape5.mirror = true;
        setRotation(Shape5, 0F, -0.5205006F, -0.3717861F);
        Shape6 = new ModelRenderer(this, 0, 0);
        Shape6.addBox(0.5F, 0F, 0F, 2, 1, 1);
        Shape6.setRotationPoint(0F, 19.5F, 1F);
        Shape6.setTextureSize(64, 32);
        Shape6.mirror = true;
        setRotation(Shape6, 0F, 0.669215F, 0.3346075F);
        Shape7 = new ModelRenderer(this, 0, 0);
        Shape7.addBox(0.5F, 0F, 0F, 2, 1, 1);
        Shape7.setRotationPoint(-3F, 20.5F, 2.5F);
        Shape7.setTextureSize(64, 32);
        Shape7.mirror = true;
        setRotation(Shape7, 0F, 0.5576792F, -0.3717861F);
    }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Shape1.render(f5);
    Shape2.render(f5);
    Shape3.render(f5);
    Shape4.render(f5);
    Shape5.render(f5);
    Shape6.render(f5);
    Shape7.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }
  
}
