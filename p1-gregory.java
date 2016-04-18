// Gregory -- Project 1 
//CST 112

float sunX, sunY; //variables for sun
float xGold, yGold; //position of gold
float xPhil, yPhil; // position of phil
float r,g,b,a; // variables for colors
float dx,dy; // variables for random gold position
float score; 
float randomGold;
float horizon;
float cloudX, cloudY; //variables for cloud

void setup() {
    size(600, 600);  //screen size
    horizon = height/4;
    reset();
    dx = random(width);
    dy = random(height);
} 

void reset(){ 
    sunX=  width/2;   // Reset the sun position.
    sunY= random (200, 250);
    cloudX= width/1;
    score = 0;
}
  
void draw() {    
    scene(); //calls the scene function
    randomColor(); //calls the random color function
    messages(); //calls the messages function 
    gold(); // calls the gold funtion
    phil(); //calls the hero function
    action(); //calls the action function
    countdown(); //counts down the score every second
}
  
void scene(){
    background(0, 175, 255);//background color
    fill(0, 200, 0); //green grass rectangle color
    rect(0, 350, 600, 300); //rectangle size
    //SUN
    fill(255, 255, 0); //sun color
    ellipse( sunX, sunY, 30, 30 );   // Yellow sun 
    //HOUSE
    fill(255, 0, 0 ); // house color 
    rect(200, 300, 100, 50 ); //house size
    triangle( 190, 300, 310, 300, 250, 250 );  // roof size
    fill(218,165,32);//door color
    rect(235,310,25,40); //door size
    fill(240,248,255); // window color
    rect(210,310,20,20); // window left
    rect(265,310,20,20); //window right
    //Tree
    fill(139,69,19);
    rect(400,250,30,100);
    fill(0,100,0);
    ellipse(415,250,70,70);
    //Cloud
    fill(255);
    ellipse(cloudX,cloudY,70,30);
    ellipse(cloudX-20,cloudY-20,70,30);
  }
  
void phil(){
    fill(255,69,0); // body color
    rect( xPhil,yPhil, 35, 60 ); // hero body
    fill(255,228,181); //head color
    ellipse( xPhil+18,yPhil, 40, 40 ); // head on top
    fill(0,0,0);
    text( "PHIL", xPhil+5,yPhil+40 ); //name
    // eyes.
    fill( r,g,b);
    ellipse(xPhil+10,yPhil-5 , 12, 12 );
    ellipse(xPhil+25,yPhil-5, 12, 12 );
   //legs  
    fill(160,82,45);
    rect( xPhil,yPhil+60,10,40 ); //left leg
    rect( xPhil+25,yPhil+60,10,40 ); //right let
   //arms
    fill(160,82,45);
    rect( xPhil-10,yPhil,10,30 ); //left arm
    rect( xPhil+35,yPhil,10,30 ); //right arm
    
  }
void action(){
    sunX = sunX + 1; //add 1 to position of sun
    if (sunX > width){
    sunX=  0;
    sunY=  random( 200, 220 ); // randomly changes the height of the sun
    }
     cloudY = 150;
    cloudX = cloudX - 3;
    if (cloudX < width/50){
      cloudX = 800;  
    }
    // Phil moves; check for gold caputure. 
     xPhil = xPhil + (xGold-xPhil)/15; // moves phil to gold x axis 
     yPhil = yPhil + (yGold-yPhil)/15; // moves phil to gold y axis  
    
    if( dist(xPhil,yPhil,xGold,yGold) <20 ){
     xGold= random (50, width-50);
     yGold= random (horizon + 50, height-50);
     xPhil = 20;
     score=score + 100; //Add 100 to score
    }  
  }
  
void countdown(){  // Reduces score by 1 every 30 frames 
     frameRate(30);
     score=score-1;
}
  
void randomColor(){  // Variables for color
  r = random(255);
  g = random(255);
  b = random(255);
 
  }
  
void messages(){
    fill(0);
    text(" Your score is:"+score,10,10 ); // displays the score 
    text(" Trevor Gregory Project 1",width/3,10);
  }
void gold(){ 
    fill(218,g,32);
    ellipse( xGold, yGold, 60,40 );
    fill(255,25,0);
    ellipse( xGold, yGold, 30,20 );
  }  
    
void mousePressed(){
    xGold= mouseX;
    yGold= mouseY;
  }
void keyPressed(){ 
    if (key == 's'){
    sunY= sunY + 50;
    }
    if (key == 'r'){
      reset();
  }
    if (key == 'q'){
      exit();
  }
  }
