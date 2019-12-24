package app;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JLabel;
import javax.swing.SwingWorker;

import org.apache.commons.lang3.time.StopWatch;




public class StopWatchClass {
	private StopWatch myStopWatch = new StopWatch();
	private JLabel display;
	private SwingWorker worker;
	private App app;
	private StWState st;
	private int minutes=0;
	private int seconds=0;
	private long time;
	private SimpleAudioPlayer simpleAudioPlayer;
	
	
	//konstruktor
	public StopWatchClass(JLabel display) {
		super();
		this.st=st.STOPPED;
		this.display = display;
		
		try {
			this.simpleAudioPlayer=new SimpleAudioPlayer();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//reset
	public void reset() {
		myStopWatch.reset();
		minutes=0;
		seconds=0;
		st = st.STOPPED;
	}

	

	
	public void setApp(App app) {
		this.app = app;
	}

	public void buttonPressed(Duration duration) {
		if(st==st.STOPPED) {
			minutes=0;
			seconds=0;
			if(duration==duration.ONEMIN) {
				this.start(1);
				st=st.RUNNNING;
			}else if(duration==duration.TWOMIN) {
				this.start(2);
				st=st.RUNNNING;
			}else if(duration==duration.THREEMIN) {
				this.start(3);
				st=st.RUNNNING;
			}else if(duration==duration.FOURMIN) {
				this.start(4);
				st=st.RUNNNING;
			}else {
				this.start(5);
				st=st.RUNNNING;
			}
			
				
		}else {
			if(!myStopWatch.isStopped()) {
				myStopWatch.stop();
			}
			myStopWatch.reset();
			st=st.STOPPED;
			minutes=0;
			seconds=0;
			if(duration==duration.ONEMIN) {
				this.start(1);
				st=st.RUNNNING;
			}else if(duration==duration.TWOMIN) {
				this.start(2);
				st=st.RUNNNING;
			}else if(duration==duration.THREEMIN) {
				this.start(3);
				st=st.RUNNNING;
			}else if(duration==duration.FOURMIN) {
				this.start(4);
				st=st.RUNNNING;
			}else {
				this.start(5);
				st=st.RUNNNING;
			}
			
			
			
			
		}
		
	}
	
	
	
	public void start(int howLong) {
		
		myStopWatch.start();

		worker = new SwingWorker<Void, String>() {

			@Override
			protected Void doInBackground() throws Exception {

				while (minutes<howLong) {
					
					Thread.sleep(1000);
					
					time =myStopWatch.getTime();
					
					
					String zaPrint=timeConv(time);
					
//					minutes=myStopWatch.getTime(TimeUnit.MINUTES);
//					seconds=myStopWatch.getTime(TimeUnit.SECONDS);
//					publish(minutes+" : "+seconds);
					publish(zaPrint);

				}
//				simpleAudioPlayer.play();
				
				simpleAudioPlayer.restart();
				myStopWatch.stop();
				myStopWatch.reset();
				return null;
				

			}

			@Override
			protected void process(List<String> chunks) {

				String time = chunks.get(chunks.size() - 1);
				
				display.setText(time);
				app.setTitle(time);

				super.process(chunks);

			}

		};
		worker.execute();

	}

	
	
	//Metoda za konverziju
		private String timeConv(Long time) {
			StringBuilder strB=new StringBuilder();
			
			
			
			

				long hours = TimeUnit.MILLISECONDS
				    .toHours(time);
				time -= TimeUnit.HOURS.toMillis(hours);

				minutes = (int) TimeUnit.MILLISECONDS
				    .toMinutes(time);
				time -= TimeUnit.MINUTES.toMillis(minutes);

				seconds = (int) TimeUnit.MILLISECONDS
				    .toSeconds(time);
				if(minutes<10) {
					strB.append("0"+minutes+":");
				}else {
					strB.append(minutes+":");
				}
				
				if(seconds<10) {
					strB.append("0"+seconds);
				}else {
					strB.append(seconds);
				}
				
				
				return strB.toString();
			
		}
	
	
	
	
}
