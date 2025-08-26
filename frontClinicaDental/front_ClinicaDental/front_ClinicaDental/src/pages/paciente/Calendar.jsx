import FullCalendar from '@fullcalendar/react'
import dayGridPlugin from '@fullcalendar/daygrid'
import interactionPlugin from "@fullcalendar/interaction"
import timeGridPlugin from "@fullcalendar/timegrid"
import esLocale from '@fullcalendar/core/locales/es'
import React from 'react'

export default function Calendar() {
    const handleDateClick = (arg) => {
        alert(arg.dateStr)
    }

    return (
        <FullCalendar
            plugins={[dayGridPlugin, timeGridPlugin, interactionPlugin]}
            initialView="timeGridWeek"
            headerToolbar={{ left: 'prev,next today', center: 'title', right: 'dayGridMonth,dayGridWeek,dayGridDay' }}
            weekends={true}
            eventBackgroundColor='#8CE7F2'
            eventTextColor='green'
            eventBorderColor='red'
            events={[
                { title: 'Revisión', start: '2025-08-25T10:00:00', end: '2025-08-25T10:45:00' },
                { title: 'Limpieza', start: '2025-08-26T12:00:00', end: '2025-08-26T12:30:00' }
            ]}
            locales={[esLocale]}
            locale="es"
            editable={true}
            nowIndicator={true}
            dateClick={handleDateClick}
            eventClick={(info) => alert(info.event.title)}
            select={(info) => alert(`Desde: ${info.startStr} Hasta: ${info.endStr}`)}


        />
    )
}

