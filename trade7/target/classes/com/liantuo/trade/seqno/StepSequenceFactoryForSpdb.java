package com.liantuo.trade.seqno;

public class StepSequenceFactoryForSpdb extends NonBlockingSequenceFactory {

	private int step;
	private long hi;
	private int lo;
	private Thread t1;

	public StepSequenceFactoryForSpdb() {
		step = 10;
		hi = 0L;
		lo = step + 1;
		
	}

	public void setStep(int i) {
		step = i;
		lo = step + 1;
	}

	protected synchronized long internalGenerate(String range, int count)
			throws Exception {
		if (lo > step) {
			long hival = super.internalGenerate(range, step) - 1L;
			lo = 1;
			hi = hival;
			if (log.isDebugEnabled())
				log.debug("new hi[type=" + type + ",step=" + step + "]: "
						+ hival);
		}
		return hi + (long) (lo++);
	}

	public void init() throws InterruptedException, Exception {
		log.debug("生成序列！");
		for (int i = 0; i < step; i++) {
			sequenceQueue.put(generate(1));
		}
		

	}
	public Object generate(){
		try {
			if(sequenceQueue.size() < step/2){
				t1 = new Thread(new Runnable(){
					@Override
					public void run() {
						try {
							init();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
					
				});
				t1.start();
			
			}
			//System.out.println(sequenceQueue.size());
			return sequenceQueue.take();
		} catch (InterruptedException e) {
			e.printStackTrace();
			return null;
		}
	}

}
