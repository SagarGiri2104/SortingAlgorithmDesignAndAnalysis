package clout.uta.sxg6582.daa_prj;

public class Sort {
	private String type;
    private int[] data;
    private long runTime;
    private long bubbleTime;
    private long selectionTime;
    private long insertionTime;
    private long heapTime;
    private long mergeTime;
    private long quickTime;
    private long quickMedianTime;
    
	public int[] getData() {
		return data;
	}
	public void setData(int[] data) {
		this.data = data;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public long getRunTime() {
		return runTime;
	}
	public void setRunTime(long runTime) {
		this.runTime = runTime;
	}

	public long getBubbleTime() {
		return bubbleTime;
	}

	public void setBubbleTime(long bubbleTime) {
		this.bubbleTime = bubbleTime;
	}

	public long getSelectionTime() {
		return selectionTime;
	}

	public void setSelectionTime(long selectionTime) {
		this.selectionTime = selectionTime;
	}

	public long getInsertionTime() {
		return insertionTime;
	}

	public void setInsertionTime(long insertionTime) {
		this.insertionTime = insertionTime;
	}

	public long getHeapTime() {
		return heapTime;
	}

	public void setHeapTime(long heapTime) {
		this.heapTime = heapTime;
	}

	public long getMergeTime() {
		return mergeTime;
	}

	public void setMergeTime(long mergeTime) {
		this.mergeTime = mergeTime;
	}

	public long getQuickTime() {
		return quickTime;
	}

	public void setQuickTime(long quickTime) {
		this.quickTime = quickTime;
	}
	public long getQuickMedianTime() {
		return quickMedianTime;
	}
	public void setQuickMedianTime(long quickMedianTime) {
		this.quickMedianTime = quickMedianTime;
	}
    
   
}
