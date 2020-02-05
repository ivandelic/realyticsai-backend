package ai.realitics.common.exception;

public enum MessageCode {
	ERROR_GENERAL_MISSING_INPUT_OBJECT // Missing input object
	, ERROR_GENERAL_MISSING_ID_UPDATE // ID should be set when updating specific object
	, ERROR_GENERAL_MISSING_ID_DELETE // ID should be set when deleting specific object
	, ERROR_GENERAL_PROVIDED_ID_INSERT // ID should not be set when inserting specific object
}
