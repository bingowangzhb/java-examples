`Future`代表着异步计算的结果。提供了用以检测计算是否完成，等待完成和获取计算结果的方法。当计算完成时，结果只能使用`get`方法，必要时将会阻塞直到结果准备就绪。取消通过执行`cancel`方法。提供了其他方法用来确定任务是否正常完成或者取消。一旦计算完成，计算不能被取消。如果出去可取消性的目的来
