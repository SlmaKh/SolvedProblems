package acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

class pointy{
	double x;
	double y;
	final double EPS = 1e-9;

	public pointy(double x , double y){
		this.x=x;
		this.y=y;
	}
	public boolean equal(double x, double y){
		return Math.abs(x-y)<=EPS;
	}
	public boolean isEqual(pointy p){
		return equal(this.x,p.x)&& equal(this.y,p.y);
	}
	public String toString(){
		return "("+x+","+y+")";
	}
}
class LineSegment {
	final double EPS = 1e-9;
	pointy start;
	pointy end;

	public LineSegment(pointy s, pointy e){
		this.start=s;
		this.end=e;
	}
	public String toString(){
		return start+" --> "+end;
	}
	public double getSlope(){
		double x1=start.x;
		double y1=start.y;
		double x2=end.x;
		double y2=end.y;
		return (double)((double)(y2-y1)/(double)(x2-x1));
	}
	public boolean common(LineSegment l){
		return start.isEqual(l.start)||start.isEqual(l.end)||end.isEqual(l.start)||end.isEqual(l.end);
	}
	public boolean commonPoint(LineSegment left, LineSegment right, LineSegment top , LineSegment bottom){
		return common(left)||common(right)||common(top)||common(bottom);
	}
	public Line makeLine(){
		if(isVertical()){
			return new Line(1,0,-1*start.x);
		}
		double b=1.0;
		double a= -1*getSlope();
		double c=-1*a*this.start.x-this.start.y;
		return new Line(a,b,c);
	}

	public boolean isSameSegment(LineSegment ls){ // exactly the same 
		return this.start.isEqual(ls.start) && this.end.isEqual(ls.end);
	}
	public boolean lessThanOrEqual(double x, double y){
		return x<y+EPS;
	}
	public boolean greaterThanOrEqual(double x, double y){
		return x>y+EPS;
	}
	public boolean inRange (pointy p){
		if(this.isVertical()){
			if(p.y<=Math.max(this.start.y, this.end.y)&&p.y>=Math.min(this.start.y, this.end.y))
				return true;
			else 
				return false;
		}
		double small = Math.min(start.x, end.x);
		double big = Math.max(start.x, end.x);
		return p.x+EPS>=small && p.x<=big+EPS;
	}
	public boolean isVertical(){
		return start.x==end.x && start.y!=end.y;
	}
	public boolean isHorizontal(){
		return start.y==end.y && start.x!=end.x;
	}
	public boolean isInside(LineSegment left, LineSegment right, LineSegment top , LineSegment bottom){

		if(start.x>=bottom.start.x && end.x<=bottom.end.x){
			double minY=Math.min(left.start.y, left.end.y);
			double maxY=Math.max(left.start.y, left.end.y);
			double min=Math.min(start.y, end.y);
			double max=Math.max(start.y, end.y); 
			if(min>=minY && max<=maxY){
				return true;
			}
			else
				return false;
		}
		return false;

	}
	public boolean helper(LineSegment ls){
		System.out.println("heree");
		double X = ls.start.x;
		double Y1 = Math.min(ls.start.y, ls.end.y);
		double Y2 = Math.max(ls.start.y, ls.end.y);
		double minX = Math.min(this.start.x, this.end.x);
		double maxX = Math.max(this.start.x, this.end.x);
		double minY = Math.min(this.start.y, this.end.y);
		double maxY = Math.max(this.start.y, this.end.y);

		if(minX<X && maxX>X){
			if(minY>=Y1 || maxY<=Y2)
				return true;
		}

		return false;
	}
	public boolean isIntersecting(LineSegment ls){
		Line l1 = this.makeLine();
		Line l2 = ls.makeLine();
		if(l1.isIntersecting(l2)){
			pointy p = l1.getIntersection(l2);
			if(this.inRange(p)&& ls.inRange(p)){
				return true;

			}
			else 
				return false;
		}
		return false;
	}
	
	public boolean onTop(LineSegment ls){
		Line l1 = this.makeLine();
		Line l2 = ls.makeLine();
		if(l2.isSame(l1)){
			if(this.inRange(ls.start)||this.inRange(ls.end))
				return true;
			else 
				return false;
		}
		return false;
	}

}

class Line{
	double a;
	double b;
	double c;
	final double EPS = 1e-9;

	public Line(double a, double b, double c){
		this.a=a;
		this.b=b;
		this.c=c;
	}
	public boolean equal(double x, double y){
		return Math.abs(x-y)<EPS;
	}
	public boolean isParallel(Line l){
		return equal(this.a,l.a)&& equal(this.b,l.b);
	}
	public boolean isSame(Line l ){
		return equal(this.a,l.a)&& equal(this.b,l.b)&& equal(this.c,l.c);
	}
	public boolean isIntersecting(Line l){
		return !isSame(l) && !isParallel(l);
	}

	public pointy getIntersection(Line l){
		double a1=this.a;
		double b1=this.b;
		double c1=this.c;
		double a2=l.a;
		double b2=l.b;
		double c2=l.c;
		double delta = a1*b2-a2*b1;
		double deltaX=-1*c1*b2+b1*c2;
		double deltaY=a1*-1*c2+c1*a2;
		return new pointy(deltaX/delta,deltaY/delta);
	}


}

public class Intersection_UVA191 {


	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int N=Integer.parseInt(br.readLine());
		for(int n=0 ;n<N;n++){
			String []temp = br.readLine().split(" ");
			double startx = Double.parseDouble(temp[0]);
			double starty = Double.parseDouble(temp[1]);
			double endx = Double.parseDouble(temp[2]);
			double endy = Double.parseDouble(temp[3]);
			double xleft = Double.parseDouble(temp[4]);
			double ytop = Double.parseDouble(temp[5]);
			double xright = Double.parseDouble(temp[6]);
			double ybottom = Double.parseDouble(temp[7]);
			LineSegment line = new LineSegment(new pointy(startx,starty),new pointy(endx,endy));
			double maxY = Math.max(ytop,ybottom);
			double minY = Math.min(ytop,ybottom);
			double maxX = Math.max(xleft,xright);
			double minX = Math.min(xleft,xright);
			LineSegment left = new LineSegment(new pointy(minX,minY),new pointy(minX,maxY));
			LineSegment right= new LineSegment(new pointy(maxX,minY),new pointy(maxX,maxY));
			LineSegment top= new LineSegment(new pointy(minX,maxY),new pointy(maxX,maxY));
			LineSegment bottom= new LineSegment(new pointy(minX,minY),new pointy(maxX,minY));
			boolean still =true;
			if(line.commonPoint(left, right, top, bottom)){
				out.println("T");
				still =false;
			}
			if(still&& line.isInside(left, right, top, bottom)){
				out.println("T");
				still =false;
			}
			if(still&&(line.isIntersecting(left)||line.isSameSegment(left)||line.isIntersecting(left))){
				out.println("T");
				still=false;
			}
			if(still &&(line.isIntersecting(right)||line.isSameSegment(right)||line.isIntersecting(right))){
				out.println("T");
				still=false;
			}
			if(still && (line.isIntersecting(top)||line.isSameSegment(top)||line.isIntersecting(top))){
				out.println("T");
				still=false;
			}
			if(still && (line.isIntersecting(bottom)||line.isSameSegment(bottom)||line.isIntersecting(bottom))){
				out.println("T");
				still=false;
			}
			if(still)
				out.println("F");

		}
		out.flush();
		out.close();
	}
}
