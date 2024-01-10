import React, { useEffect } from 'react';
import { useHeaderMemory } from '../../../component/context/HeaderContext';

const ProjectNewCreate = () => {

    const { updatePageType } = useHeaderMemory();

    useEffect(() => {
        updatePageType('createMain');
    }, [updatePageType]);

    return (
        <div>민민</div>
    );
};

export default ProjectNewCreate;