/**
 * 调用后台批量删除方法
 */
function deleteBatch(basePath) {
	$("#mainForm").attr("action", basePath + "DeleteBatch.action");
	$("#mainForm").submit();
}

/**
 * 调用后台单个删除方法
 */
function deleteOne(basePath) {
	$("#mainForm").attr("action", basePath + "DeleteOne.action");
	$("#mainForm").submit();
}