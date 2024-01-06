import React from 'react';
import { useHeaderMemory } from '../../../component/context/HeaderContext';

const ProjectNewCreate = () => {

    const { updatePageType } = useHeaderMemory();

    updatePageType('createMain');

    return (
        <div>민민</div>
    );
};

export default ProjectNewCreate;