package com.hulkapps.restservicetodoapp.utils.exceptions

import java.lang.Exception

class TaskException(override val message: String?): Exception(message)